package com.code.qrcodeback.controller;

import com.code.qrcodeback.entity.Ad;
import com.code.qrcodeback.link.FixAndUser;
import com.code.qrcodeback.service.AdService;
import com.code.qrcodeback.utils.result.DataResult;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * (Ad)表控制层
 *
 * @author makejava
 * @since 2023-04-06 16:10:49
 */
@RestController
@RequestMapping("ad")
public class AdController {
    /**
     * 服务对象
     */
    @Resource
    private AdService adService;

    /**
     * 分页查询
     *
     * @param ad 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Ad>> queryByPage(Ad ad, PageRequest pageRequest) {
        return ResponseEntity.ok(this.adService.queryByPage(ad, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Ad> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.adService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param ad 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public DataResult add(@RequestBody Ad ad) {

        return DataResult.successByData(this.adService.insert(ad));
    }

    /**
     * 编辑数据
     *
     * @param ad 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Ad> edit(Ad ad) {
        return ResponseEntity.ok(this.adService.update(ad));
    }


    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(@RequestBody Ad ad) {
        return ResponseEntity.ok(this.adService.deleteById(ad.getAdId()));
    }


    //    报修列表全部
    @PostMapping("search")
    public DataResult search() {
        List<Ad> AdList = adService.searchAll();



        return DataResult.successByDataArray(AdList);
    }

    //上传图片
    @PostMapping(value = "/image/upload" )
    @ResponseBody
    public String imageUpload(HttpServletRequest request, @RequestParam("file") MultipartFile fileUpload) throws ParseException {

        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        String tmpFilePath =  "E://springboot//QRcodeback//src//main//resources//static//image//ad"  ;

        //没有路径就创建路径
        File tmp = new File(tmpFilePath);
        if (!tmp.exists()) {
            tmp.mkdirs();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
        Date date =new Date();
        String d = sdf.format(date);
        String resourcesPath = tmpFilePath + "//" +d+"-"+fileName;
        String savePath="http://47.100.242.36:6001/Image/ad/"+d+"-"+fileName;

        File upFile = new File(resourcesPath);
        try {
            Ad ad =new Ad();
            ad.setAdName(savePath);
            adService.insert(ad);
            fileUpload.transferTo(upFile);


            return savePath;
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }

    }
}

