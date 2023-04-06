package com.code.qrcodeback.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Qrcode)实体类
 *
 * @author makejava
 * @since 2023-04-06 16:11:11
 */
public class Qrcode implements Serializable {
    private static final long serialVersionUID = -72222133593560063L;
    
    private Integer codeId;
    
    private Integer userId;
    
    private Object codeImage;
    
    private Date validTime;


    public Integer getCodeId() {
        return codeId;
    }

    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Object getCodeImage() {
        return codeImage;
    }

    public void setCodeImage(Object codeImage) {
        this.codeImage = codeImage;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

}

