package com.code.qrcodeback.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.alibaba.fastjson.JSONObject;
import com.code.qrcodeback.entity.Record;
import com.code.qrcodeback.entity.User;
import com.code.qrcodeback.service.RecordService;
import com.code.qrcodeback.service.UserService;
import com.code.qrcodeback.utils.result.DataResult;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * (Qrcode)表控制层
 *
 * @author makejava
 * @since 2023-04-06 16:11:11
 */
@RestController
@RequestMapping("qrcode")
public class QrcodeController {
    /**
     * 服务对象
     */

    @Resource
    private UserService userService;
    @Resource
    private RecordService recordService;


    //  二维码生成
    @PostMapping("/generateCode")
    public DataResult generateCode(@RequestBody User user) {
        QrConfig config = new QrConfig(350, 350);
        // 高纠错级别L、M、Q、H
        config.setErrorCorrection(ErrorCorrectionLevel.H);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date();
        String d = sdf.format(date);
        String d2 = sdf2.format(date);
        String saveFile = "E://springboot//QRcodeback//src//main//resources//static//image//code//";
        String generate = "user-" + user.getUserId() + "-" + d2 + ".jpg";
        String path = saveFile + generate;

        String path2 = "http://47.100.242.36:6001/Image/code/" + generate;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("codeImage", path2);

        User user1 = this.userService.queryById(user.getUserId());
        if (user1.getUserState().equals(0)) {
            return DataResult.errByErrCode(108);
        }
        user.setUserState(user1.getUserState());
        user.setUserPassword(user1.getUserPassword());
        user.setUserType(user1.getUserType());
        user.setUserImage(user1.getUserImage());
        user.setUserName(user1.getUserName());
        //封装
        JSONObject o = new JSONObject();
        o.put("userInfo", user);
        String content = o.toString();
        System.err.println(content);
        String md5result = DigestUtil.md5Hex(content);
        System.err.println(md5result);
        JSONObject gen = new JSONObject();
        gen.put("key", user1.getUserId());
        gen.put("code", md5result);
        gen.put("time", d);
        content = gen.toString();
        QrCodeUtil.generate(content, config, FileUtil.file(path));

        return DataResult.successByData(jsonObject);


    }

    //  扫门禁
    @PostMapping("/request")
    public DataResult request(HttpServletRequest request, @RequestBody String verify) throws ParseException {


        System.err.println("verify:" + verify);

        JSONObject jsonObject = JSONObject.parseObject(verify);

        String userId = jsonObject.getJSONObject("verify").get("userId").toString();
        String userName = jsonObject.getJSONObject("verify").get("userName").toString();
        String userIdcard = jsonObject.getJSONObject("verify").get("userIdcard").toString();
        String time = jsonObject.get("time").toString();
        System.err.println("time:" + time);
        User user = this.userService.queryById(Integer.valueOf(userId));

        if (user.getUserName().equals(userName)
                && user.getUserIdcard().equals(userIdcard)) {
            if (user.getUserState().equals(0)) {
                return DataResult.errByErrCode(108);
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = sdf.parse(time);
                Record record =new Record();
                record.setBackTime(date);
                record.setRecordUserId(Integer.valueOf(userId));
                this.recordService.insert(record);
                //游客扫完后回归0
                if(user.getUserType()==2){
                    user.setUserState(0);
                    userService.update(user);
                }
                return DataResult.errByErrCode(200);
            }

        }

        return DataResult.errByErrCode(100);


    }

    //被扫
    @PostMapping("/verify")
    public DataResult verify(HttpServletRequest request, @RequestBody String verify) throws ParseException {

        try {
            //获取源数据转换为json
            System.err.println("verify:" + verify);
            JSONObject jsonObject = JSONObject.parseObject(verify);
            String time=JSONObject.parseObject(jsonObject.getString("verify")).get("time").toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dateNow =new Date();
            Date date = sdf.parse(time);
            long s=(dateNow.getTime()-date.getTime())/(1000);//化为秒 1分钟过期
            System.err.println("s:"+s);
            //数据库取值
            JSONObject Json = JSONObject.parseObject(jsonObject.getString("verify"));
            System.err.println("Json"+Json);
            String userId = Json.get("key").toString();
            System.err.println("userId"+userId);
            User user1 = this.userService.queryById(Integer.valueOf(userId));
            System.err.println("user1"+user1);
            User user = new User();
            user.setUserId(user1.getUserId());
            user.setUserState(user1.getUserState());
            if(user.getUserState().equals(0)){
                //无权限
                return DataResult.errByErrCode(108);
            }
            if(s>60){
                //二维码过期
                return DataResult.errByErrCode(107);
            }
            user.setUserPassword(user1.getUserPassword());
            user.setUserType(user1.getUserType());
            user.setUserImage(user1.getUserImage());
            user.setUserName(user1.getUserName());
            //封装
            JSONObject o = new JSONObject();
            o.put("userInfo", user);
            String content = o.toString();
            System.err.println(content);
            String md5result = DigestUtil.md5Hex(content);


            if (Json.get("code").toString().equals(md5result)) {
                if(user.getUserType().equals(2)){
                    User user2 = new User();
                    user2.setUserId(user1.getUserId());
                    user2.setUserState(0);
                    this.userService.update(user2);
                }
                //插入数据

                Record record =new Record();
                record.setBackTime(new Date());
                record.setRecordUserId(Integer.valueOf(userId));
                this.recordService.insert(record);
                return DataResult.errByErrCode(200);


            }
            //错误
            return DataResult.errByErrCode(100);
        } catch (Exception e) {
            //错误
            return DataResult.errByErrCode(100);
        }



    }

}

