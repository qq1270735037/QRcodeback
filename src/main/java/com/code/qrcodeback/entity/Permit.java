package com.code.qrcodeback.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Permit)实体类
 *
 * @author makejava
 * @since 2023-04-06 16:11:11
 */
public class Permit implements Serializable {
    private static final long serialVersionUID = 636552781225842552L;
    
    private Integer permitId;
    
    private Integer userId;
    
    private Integer permitState;
    
    private Date permitTime;


    public Integer getPermitId() {
        return permitId;
    }

    public void setPermitId(Integer permitId) {
        this.permitId = permitId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPermitState() {
        return permitState;
    }

    public void setPermitState(Integer permitState) {
        this.permitState = permitState;
    }

    public Date getPermitTime() {
        return permitTime;
    }

    public void setPermitTime(Date permitTime) {
        this.permitTime = permitTime;
    }

    @Override
    public String toString() {
        return "Permit{" +
                "permitId=" + permitId +
                ", userId=" + userId +
                ", permitState=" + permitState +
                ", permitTime=" + permitTime +
                '}';
    }
}

