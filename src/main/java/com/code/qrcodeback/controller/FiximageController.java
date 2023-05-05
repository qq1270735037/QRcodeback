package com.code.qrcodeback.controller;

import com.code.qrcodeback.entity.Fiximage;
import com.code.qrcodeback.service.FiximageService;
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
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public String imageUpload(HttpServletRequest request, @RequestParam("file") MultipartFile fileUpload) throws ParseException {
        String userId = request.getParameter("uploadid");
        System.err.println("uploadid:"+userId);
        System.err.println("uploadid:"+userId);
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        String tmpFilePath =  "E://springboot//QRcodeback//src//main//resources//static//image//fix"  ;

        //没有路径就创建路径
        File tmp = new File(tmpFilePath);
        if (!tmp.exists()) {
            tmp.mkdirs();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
        Date date =new Date();
        String d = sdf.format(date);
        String resourcesPath = tmpFilePath + "//" +d+"-"+fileName;
        String savePath="http://47.100.242.36:6001/Image/fix/"+d+"-"+fileName;

        File upFile = new File(resourcesPath);
        try {
            Fiximage fiximage=new Fiximage();
            fiximage.setFixId(Integer.valueOf(userId));
            fiximage.setImagePic(savePath);
            fiximageService.insert(fiximage);
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
    //传回图片
//    @GetMapping("/getFixImage")
//    public String getFixImage (@RequestParam("fixImageId") String fixImageId,HttpServletResponse response)throws ParseException {
//        System.err.println("res:"+fixImageId);
//        File file = new File(fixImageId );
//        byte[] bytes = new byte[1024];
//        try (OutputStream os = response.getOutputStream();
//             FileInputStream fis = new FileInputStream(file)){
//            while ((fis.read(bytes)) != -1) {
//                os.write(bytes);
//                os.flush();
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "success";
//    }

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

