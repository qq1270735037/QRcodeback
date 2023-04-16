package com.code.qrcodeback;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
/**
 * 跨域
 */
@CrossOrigin
public class test {
    @GetMapping("/")
    @ResponseBody
    public String test1(){
        return "test1";
    }

}
