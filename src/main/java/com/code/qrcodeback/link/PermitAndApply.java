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
public class PermitAndApply {
    private Integer permitId;
    private Integer applyId;
    private Integer applyUser;
    private Integer permitState;
    private Date permitTime;
    private String userName;
    private String userImage;


}
