package com.code.qrcodeback.controller;

import com.code.qrcodeback.entity.User;
import com.code.qrcodeback.service.UserService;
import com.code.qrcodeback.utils.result.DataResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;


@RestController
public class registerController {
    @Resource
    private UserService userService;

    @PostMapping("register")
    public DataResult register(@RequestBody User user, HttpSession session) throws ParseException {
        System.err.println("user:" + user.toString());
        User loginUser =userService.queryById(user.getUserId());
        if(loginUser==null) {
            user.setUserState(0);
//            user.setUserType(2);
            userService.insert(user);
            return DataResult.succ();
        }
        else{
            return DataResult.errByErrCode(101);
        }




    }
}

