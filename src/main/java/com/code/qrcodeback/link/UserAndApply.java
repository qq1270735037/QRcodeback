package com.code.qrcodeback.link;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserAndApply {


    private Integer applyId;
    private String userName;
    private String userImage;
    private Integer applyUser;

    private Date applyTime;

    private Integer applyState;

    private String applyMessage;
}
