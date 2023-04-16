package com.code.qrcodeback.entity;

import java.io.Serializable;

/**
 * (Ad)实体类
 *
 * @author makejava
 * @since 2023-04-06 16:11:03
 */
public class Ad implements Serializable {
    private static final long serialVersionUID = -80784363539778632L;
    
    private Integer adId;

    private Integer userId;
    
    private String adName;
    
    private String adMessage;


    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdMessage() {
        return adMessage;
    }

    public void setAdMessage(String adMessage) {
        this.adMessage = adMessage;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "adId=" + adId +
                ", userId=" + userId +
                ", adName='" + adName + '\'' +
                ", adMessage='" + adMessage + '\'' +
                '}';
    }
}

