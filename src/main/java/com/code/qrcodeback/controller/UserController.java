package com.code.qrcodeback.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.code.qrcodeback.entity.Fiximage;
import com.code.qrcodeback.entity.User;
import com.code.qrcodeback.service.RecordService;
import com.code.qrcodeback.service.UserService;
import com.code.qrcodeback.utils.result.DataResult;
import com.code.qrcodeback.vo.UserVo;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2023-04-15 21:25:44
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    private RecordService recordService;

    @PostMapping("searchByPage")
    public DataResult queryByPage(@RequestBody UserVo userVo) {
        System.err.println(userVo.toString());
        Long cnt=this.userService.count();
        if(userVo.getPage()+userVo.getLimit()<=cnt){
            System.err.println("cnt:"+cnt);
            List<User> o = this.userService.queryByPage(userVo.getPage(), userVo.getLimit());
            return DataResult.successByDataArray(o);
        }
        if(userVo.getPage()<cnt){
            System.err.println("cnt:"+cnt);
            List<User> o = this.userService.queryByPage(userVo.getPage(), cnt-userVo.getPage());
            return DataResult.successByDataArray(o);
        }

        return DataResult.errByErrCode(100);

    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public DataResult edit(@RequestBody User user) {
        System.err.println("static.user" +user.toString());
        User changeUser =this.userService.queryById(user.getUserId());
        if (changeUser != null ) {
//            changeUser.setUserName(user.getUserName());
//            System.err.println("user"+changeUser.toString());
            this.userService.update(user);
            changeUser =this.userService.queryById(user.getUserId());
            changeUser.setUserPassword("");
            return DataResult.successByData(changeUser);


        } else {
            return DataResult.errByErrCode(100);
        }
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }


    //传回图片
    @GetMapping("/image")
    public String image (@RequestParam("userImage") String userImage,HttpServletResponse response)throws ParseException {
        System.err.println("res:"+userImage);
        File file = new File(userImage );
        byte[] bytes = new byte[1024];
        try (OutputStream os = response.getOutputStream();
             FileInputStream fis = new FileInputStream(file)){
            while ((fis.read(bytes)) != -1) {
                os.write(bytes);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
    //   出行记录查询
    @PostMapping("/travel" )
    public DataResult insert(@RequestBody User user, HttpSession session) throws ParseException {
        System.err.println("user:" + user.toString());

            return DataResult.errByErrCode(101);


    }

    //  查询全部
    @PostMapping("/queryAll" )
    public DataResult queryAll() {
        List<User> o = this.userService.queryAll();
        for (int i = 0; i < o.size(); i++) {
            System.err.println(o.get(i).toString());
        }
        return DataResult.successByDataArray(o);


    }
    //  通过Id查
    @PostMapping("/searchById" )
    public DataResult searchById(@RequestBody User user) {
        List<User> o = this.userService.searchById(user.getUserId());
        for (int i = 0; i < o.size(); i++) {
            System.err.println(o.get(i).toString());
        }
        return DataResult.successByDataArray(o);


    }
    //  通过Name查
    @PostMapping("/searchByName" )
    public DataResult searchByName(@RequestBody User user) {
        List<User> o = this.userService.searchByName(user.getUserName());
        for (int i = 0; i < o.size(); i++) {
            System.err.println(o.get(i).toString());
        }
        return DataResult.successByDataArray(o);


    }
    //  通过证件查
    @PostMapping("/searchByIdCard" )
    public DataResult searchByIdCard(@RequestBody User user) {
        String s= String.valueOf(user.getUserIdcard());
        List<User> o = this.userService.searchByIdCard(s);
        for (int i = 0; i < o.size(); i++) {
            System.err.println(o.get(i).toString());
        }
        return DataResult.successByDataArray(o);


    }
    //上传图片
    @PostMapping(value = "/image/upload" )
    @ResponseBody
    public String imageUpload(HttpServletRequest request, @RequestParam("file") MultipartFile fileUpload) throws ParseException {
        String userId = request.getParameter("uploadid");
        System.err.println("uploadid:"+userId);

        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        String tmpFilePath =  "E://springboot//QRcodeback//src//main//resources//static//image//user"  ;

        //没有路径就创建路径
        File tmp = new File(tmpFilePath);
        if (!tmp.exists()) {
            tmp.mkdirs();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
        Date date =new Date();
        String d = sdf.format(date);
        String resourcesPath = tmpFilePath + "//" +d+"-"+fileName;
        String savePath="http://47.100.242.36:6001/Image/user/"+d+"-"+fileName;

        File upFile = new File(resourcesPath);
        try {
//            User user =new User();
//            user.setUserId(Integer.valueOf(userId));
//            user.setUserImage(savePath);
//            userService.update(user);
//            System.err.println(user);
            fileUpload.transferTo(upFile);
            //压缩图片大小
            try {
                //图片所在路径
                BufferedImage templateImage = ImageIO.read(new File(resourcesPath));


                //原始图片的长度和宽度
                int height = templateImage.getHeight();
                int width = templateImage.getWidth();

                //通过比例压缩
                float scale = 0.4f;

                //通过固定长度压缩
            /*int doWithHeight = 100;
            int dowithWidth = 300;*/

                //压缩之后的长度和宽度
                int doWithHeight = (int) (scale * height);
                int dowithWidth = (int) (scale * width);

                BufferedImage finalImage = new BufferedImage(dowithWidth, doWithHeight, BufferedImage.TYPE_INT_RGB);

                finalImage.getGraphics().drawImage(templateImage.getScaledInstance(dowithWidth, doWithHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);


                //图片输出路径，以及图片名
                FileOutputStream fileOutputStream = new FileOutputStream(resourcesPath);
                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fileOutputStream);
                encoder.encode(finalImage);
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                return "fail";
            }
            return savePath;
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }

    }


}

