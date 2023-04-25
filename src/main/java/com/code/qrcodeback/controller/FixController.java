package com.code.qrcodeback.controller;

import com.alibaba.fastjson.JSONObject;
import com.code.qrcodeback.entity.Fix;
import com.code.qrcodeback.entity.User;
import com.code.qrcodeback.link.FixAndUser;
import com.code.qrcodeback.link.UserAndApply;
import com.code.qrcodeback.service.FixService;
import com.code.qrcodeback.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * (Fix)表控制层
 *
 * @author makejava
 * @since 2023-04-06 16:11:11
 */

@RestController
@RequestMapping("fix")
public class FixController {
    /**
     * 服务对象
     */
    @Resource
    private FixService fixService;

    /**
     * 分页查询
     *
     * @param fix         筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Fix>> queryByPage(Fix fix, PageRequest pageRequest) {
        return ResponseEntity.ok(this.fixService.queryByPage(fix, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Fix> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.fixService.queryById(id));
    }

    //    //上传图片
//    @PostMapping(value = "/image/upload" )
//    @ResponseBody
//    public String imageUpload(HttpServletRequest request, @RequestParam("file") MultipartFile fileUpload) {
//        String userId = request.getParameter("uploadid");
//        System.err.println("uploadid:"+userId);
//        System.err.println("uploadid:"+userId);
//        //获取文件名
//        String fileName = fileUpload.getOriginalFilename();
//        String tmpFilePath =  "E://springboot//QRcodeback//src//fixImage"  ;
//
//        //没有路径就创建路径
//        File tmp = new File(tmpFilePath);
//        if (!tmp.exists()) {
//            tmp.mkdirs();
//        }
//        String resourcesPath = tmpFilePath + "//" + fileName;
//
//        File upFile = new File(resourcesPath);
//        try {
//            fileUpload.transferTo(upFile);
//            return resourcesPath;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "fail";
//        }
//
//    }
//    //传回图片
//    @GetMapping("/image/look")
//    public String imageLook(HttpServletResponse response) {
//
//        File file = new File("E://springboot//QRcodeback//src//fixImage//mmexport1579364604307.jpg");
//        byte[] bytes = new byte[1024];
//        try (OutputStream os = response.getOutputStream();
//             FileInputStream fis = new FileInputStream(file)) {
//            while ((fis.read(bytes)) != -1) {
//                os.write(bytes);
//                os.flush();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "success";
//    }

    /**
     * 新增数据
     *
     * @param fix 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Fix> add(Fix fix) {
        return ResponseEntity.ok(this.fixService.insert(fix));
    }

    /**
     * 编辑数据
     *
     * @param fix 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Fix> edit(Fix fix) {
        return ResponseEntity.ok(this.fixService.update(fix));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.fixService.deleteById(id));
    }


    //    报修上传
    @PostMapping("upload")
    public DataResult login(@RequestBody Fix fix, HttpSession session) throws ParseException {
        System.err.println("user:" + fix.toString());
        if (fix != null) {

            Fix fix2 = fixService.insert(fix);
            int id = fix2.getFixId();

            System.err.println(fix2.toString());
            return DataResult.successByData(fix);


        } else {
            return DataResult.errByErrCode(101);
        }


    }

    //    申请列表
    @PostMapping("search")
    public DataResult search() {
        List<FixAndUser> FixAndUserList = fixService.queryAllFixAndUser();
        //先排序时间后逆序
        Collections.sort(FixAndUserList, Comparator.comparing(FixAndUser::getFixState).reversed());

        for (int i = 0; i < FixAndUserList.size(); i++) {
            System.err.println(FixAndUserList.get(i).toString());
        }

        return DataResult.successByDataArray(FixAndUserList);
    }


}

