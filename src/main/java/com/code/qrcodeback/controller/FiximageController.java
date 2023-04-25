package com.code.qrcodeback.controller;

import com.code.qrcodeback.entity.Fiximage;
import com.code.qrcodeback.service.FiximageService;
import com.code.qrcodeback.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;

/**
 * (Fiximage)表控制层
 *
 * @author makejava
 * @since 2023-04-23 00:17:55
 */
@RestController
@RequestMapping("fiximage")
public class FiximageController {
    /**
     * 服务对象
     */
    @Resource
    private FiximageService fiximageService;

    /**
     * 分页查询
     *
     * @param fiximage 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Fiximage>> queryByPage(Fiximage fiximage, PageRequest pageRequest) {
        return ResponseEntity.ok(this.fiximageService.queryByPage(fiximage, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Fiximage> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.fiximageService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param fiximage 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Fiximage> add(Fiximage fiximage) {
        return ResponseEntity.ok(this.fiximageService.insert(fiximage));
    }

    /**
     * 编辑数据
     *
     * @param fiximage 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Fiximage> edit(Fiximage fiximage) {
        return ResponseEntity.ok(this.fiximageService.update(fiximage));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.fiximageService.deleteById(id));
    }


    //上传图片
    @PostMapping(value = "/image/upload" )
    @ResponseBody
    public String imageUpload(HttpServletRequest request, @RequestParam("file") MultipartFile fileUpload) {
        String userId = request.getParameter("uploadid");
        System.err.println("uploadid:"+userId);
        System.err.println("uploadid:"+userId);
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        String tmpFilePath =  "E://springboot//QRcodeback//src//fixImage"  ;

        //没有路径就创建路径
        File tmp = new File(tmpFilePath);
        if (!tmp.exists()) {
            tmp.mkdirs();
        }
        String resourcesPath = tmpFilePath + "//" + fileName;

        File upFile = new File(resourcesPath);
        try {
            Fiximage fiximage=new Fiximage();
            fiximage.setFixId(Integer.valueOf(userId));
            fiximage.setImagePic(resourcesPath);
            fiximageService.insert(fiximage);
            fileUpload.transferTo(upFile);
            return resourcesPath;
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }

    }
    //传回图片
    @GetMapping("/getFixImage")
    public String getFixImage (@RequestParam("fixImageId") String fixImageId,HttpServletResponse response)throws ParseException {
        System.err.println("res:"+fixImageId);
        File file = new File(fixImageId );
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

    //传回图片地址列表
    @PostMapping("getImageList")
    public DataResult getImageList(@RequestBody Fiximage fiximage){
        System.err.println("fiximage:"+fiximage.toString());
        List<Fiximage> image =fiximageService.queryByfixId(fiximage.getFixId());
        for (int i = 0; i <image.size() ; i++) {
            System.err.println("image:"+image.get(i).getImagePic());
        }
        return DataResult.successByDataArray(image);
    }
}

