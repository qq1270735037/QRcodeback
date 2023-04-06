package com.code.qrcodeback.entity;

import java.io.Serializable;

/**
 * (UserRecord)实体类
 *
 * @author makejava
 * @since 2023-04-06 16:11:12
 */
public class UserRecord implements Serializable {
    private static final long serialVersionUID = -86187240625177641L;
    
    private Integer userId;
    
    private Integer recordId;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

}

