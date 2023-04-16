package com.code.qrcodeback.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2023-04-17 00:45:08
 */
public class User implements Serializable {
    private static final long serialVersionUID = -98628594794053793L;
    
    private Integer userId;
    
    private String userPassword;
    
    private Integer codeId;
    
    private String userName;
    
    private String userGender;
    
    private Integer userType;
    
    private String userImage;
    
    private Long userNumber;
    
    private Date userDate;
    
    private Integer userState;
    
    private Long userIdcard;
    
    private Integer userLocation;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getCodeId() {
        return codeId;
    }

    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public Long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Long userNumber) {
        this.userNumber = userNumber;
    }

    public Date getUserDate() {
        return userDate;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public Long getUserIdcard() {
        return userIdcard;
    }

    public void setUserIdcard(Long userIdcard) {
        this.userIdcard = userIdcard;
    }

    public Integer getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(Integer userLocation) {
        this.userLocation = userLocation;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userPassword='" + userPassword + '\'' +
                ", codeId=" + codeId +
                ", userName='" + userName + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userType=" + userType +
                ", userImage='" + userImage + '\'' +
                ", userNumber=" + userNumber +
                ", userDate=" + userDate +
                ", userState=" + userState +
                ", userIdcard=" + userIdcard +
                ", userLocation=" + userLocation +
                '}';
    }
}

