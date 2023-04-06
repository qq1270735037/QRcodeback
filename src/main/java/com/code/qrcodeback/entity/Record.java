package com.code.qrcodeback.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Record)实体类
 *
 * @author makejava
 * @since 2023-04-06 16:11:11
 */
public class Record implements Serializable {
    private static final long serialVersionUID = 579174799078644408L;
    
    private Integer recordId;
    
    private Date travelTime;
    
    private Date backTime;
    
    private Integer recordUserId;


    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Date getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(Date travelTime) {
        this.travelTime = travelTime;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    public Integer getRecordUserId() {
        return recordUserId;
    }

    public void setRecordUserId(Integer recordUserId) {
        this.recordUserId = recordUserId;
    }

}

