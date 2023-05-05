package com.code.qrcodeback.link;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecordAndUser {

    private Integer recordId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date backTime;

    private Integer recordUserId;

    private String userName;
    private String userImage;
}
