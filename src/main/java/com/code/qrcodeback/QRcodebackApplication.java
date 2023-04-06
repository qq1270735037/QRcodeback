package com.code.qrcodeback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.code.qrcodeback.dao")
public class QRcodebackApplication {

    public static void main(String[] args) {
        SpringApplication.run(QRcodebackApplication.class, args);
    }

}
