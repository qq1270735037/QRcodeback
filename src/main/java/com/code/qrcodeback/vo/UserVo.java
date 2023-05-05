package com.code.qrcodeback.vo;

import com.code.qrcodeback.entity.User;
import lombok.Data;

@Data
public class UserVo extends User {
    private Long page;//当前页码
    private Long limit;//每页条数
}