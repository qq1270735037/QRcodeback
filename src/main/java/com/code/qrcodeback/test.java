package com.code.qrcodeback;

import com.code.qrcodeback.entity.Apply;
import com.code.qrcodeback.link.PermitAndApply;
import com.code.qrcodeback.link.UserAndApply;
import com.code.qrcodeback.service.ApplyService;
import com.code.qrcodeback.service.PermitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@Controller

public class test {
    @Resource
    private ApplyService applyService;
    private PermitService permitService;
    @GetMapping("/kk")
    @ResponseBody
    public String test1() throws ParseException {

        Apply apply =new Apply();
//        for (int i = 0; i < 3; i++) {
//
//            Random random = new Random();
//            int y = 2022;
//            int d =  random.nextInt(28);
//            int m =  random.nextInt(12);
//            int h=10+random.nextInt(13);
//            int mm=random.nextInt(60);
//            int ss=random.nextInt(60);
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String s=y+"-"+m+"-"+d+" "+h+":"+mm+":"+ss;
//            Date date =new Date();
//            date= sdf.parse(s);
//            apply.setUserId(1);
//            apply.setApplyUser(10017);
//            apply.setApplyTime(date);
//            apply.setApplyState(0);
//            apply.setApplyMessage("申请出行");
//            applyService.insert(apply);
//            System.err.println(date);
//        }




        return "test1";
    }

}
