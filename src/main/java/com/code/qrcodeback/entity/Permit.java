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
 * (Permit)实体类
 *
 * @author makejava
 * @since 2023-04-23 22:50:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Permit implements Serializable {
    private static final long serialVersionUID = -21789152885822843L;
    
    private Integer permitId;
    
    private Integer applyId;
    
    private Integer permitState;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
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

