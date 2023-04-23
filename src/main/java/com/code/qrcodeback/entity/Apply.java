package com.code.qrcodeback.entity;

import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * (Apply)实体类
 *
 * @author makejava
 * @since 2023-04-22 22:30:38
 */
@ToString
public class Apply implements Serializable {
    private static final long serialVersionUID = 847407592684096241L;
    
    private Integer applyId;
    
    private Integer applyUser;
    
    private Integer applyOwner;
    
    private Date applyTime;
    
    private Integer applyState;
    
    private String applyMessage;


    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Integer getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(Integer applyUser) {
        this.applyUser = applyUser;
    }

    public Integer getApplyOwner() {
        return applyOwner;
    }

    public void setApplyOwner(Integer applyOwner) {
        this.applyOwner = applyOwner;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getApplyState() {
        return applyState;
    }

    public void setApplyState(Integer applyState) {
        this.applyState = applyState;
    }

    public String getApplyMessage() {
        return applyMessage;
    }

    public void setApplyMessage(String applyMessage) {
        this.applyMessage = applyMessage;
    }

}

