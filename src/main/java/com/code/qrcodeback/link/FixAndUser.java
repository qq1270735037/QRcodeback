package com.code.qrcodeback.link;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FixAndUser {
    private Integer fixId;
    private Integer userId;
    private Long userNumber;
    private String userName;
    private String fixName;
    private Integer fixState;
    private String fixMessage;
    private List<String> fixImage;
}
