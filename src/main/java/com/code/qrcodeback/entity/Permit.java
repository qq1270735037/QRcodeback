package com.code.qrcodeback.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Permit)实体类
 *
 * @author makejava
 * @since 2023-04-23 22:50:34
 */
public class Permit implements Serializable {
    private static final long serialVersionUID = -21789152885822843L;
    
    private Integer permitId;
    
    private Integer applyId;
    
    private Integer permitState;
    
    private Date permitTime;


    public Integer getPermitId() {
        return permitId;
    }

    public void setPermitId(Integer permitId) {
        this.permitId = permitId;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
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

}

