package com.code.qrcodeback.entity;

import java.io.Serializable;

/**
 * (Fix)实体类
 *
 * @author makejava
 * @since 2023-04-06 16:11:11
 */
public class Fix implements Serializable {
    private static final long serialVersionUID = 899098834604017014L;
    
    private Integer fixId;
    
    private Integer userId;
    
    private String fixName;
    
    private Integer fixState;
    
    private Object fixImage;
    
    private String fixMessage;


    public Integer getFixId() {
        return fixId;
    }

    public void setFixId(Integer fixId) {
        this.fixId = fixId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFixName() {
        return fixName;
    }

    public void setFixName(String fixName) {
        this.fixName = fixName;
    }

    public Integer getFixState() {
        return fixState;
    }

    public void setFixState(Integer fixState) {
        this.fixState = fixState;
    }

    public Object getFixImage() {
        return fixImage;
    }

    public void setFixImage(Object fixImage) {
        this.fixImage = fixImage;
    }

    public String getFixMessage() {
        return fixMessage;
    }

    public void setFixMessage(String fixMessage) {
        this.fixMessage = fixMessage;
    }

}

