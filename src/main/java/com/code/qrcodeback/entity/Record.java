package com.code.qrcodeback.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Record)实体类
 *
 * @author makejava
 * @since 2023-04-06 16:11:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Record implements Serializable {
    private static final long serialVersionUID = 579174799078644408L;
    
    private Integer recordId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date travelTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
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

    @Override
    public String toString() {
        return "Record{" +
                "recordId=" + recordId +
                ", travelTime=" + travelTime +
                ", backTime=" + backTime +
                ", recordUserId=" + recordUserId +
                '}';
    }
}

