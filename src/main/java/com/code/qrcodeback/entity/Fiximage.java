package com.code.qrcodeback.entity;

import lombok.ToString;

import java.io.Serializable;

/**
 * (Fiximage)实体类
 *
 * @author makejava
 * @since 2023-04-23 00:17:55
 */
@ToString
public class Fiximage implements Serializable {
    private static final long serialVersionUID = 580715829537663889L;
    
    private Integer imageId;
    
    private String imagePic;
    
    private Integer fixId;


    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImagePic() {
        return imagePic;
    }

    public void setImagePic(String imagePic) {
        this.imagePic = imagePic;
    }

    public Integer getFixId() {
        return fixId;
    }

    public void setFixId(Integer fixId) {
        this.fixId = fixId;
    }

}

