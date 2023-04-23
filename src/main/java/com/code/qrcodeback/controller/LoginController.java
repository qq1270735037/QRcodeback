package com.code.qrcodeback.controller;

import com.code.qrcodeback.entity.User;
import com.code.qrcodeback.service.UserService;
import com.code.qrcodeback.utils.result.DataResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;


@RestController
public class LoginController {
    @Resource
    private UserService userService;

    @PostMapping("login")
    public DataResult login(@RequestBody User user, HttpSession session) throws ParseException {
        System.err.println("user:" + user.toString());
        User loginUser = userService.queryById(user.getUserId());
//        System.err.println("user:"+loginUser.toString());

        //数据生成
//        for (int i = 0; i < 100; i++) {
//            User addUser=new User();
////            addUser.setUserId(10000+i+3);
//            Random random = new Random();
//            int y = 1980+ random.nextInt(42);
//            int d =  random.nextInt(28);
//            int m =  random.nextInt(12);
//            addUser.setUserImage("E://springboot//QRcodeback//src//fixImage//default.jpg");
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            String s=y+"-"+m+"-"+d;
//            Date date =sdf.parse(s);
////            sdf.format(date);
//            addUser.setUserDate(date);
//            if(i%2==0){addUser.setUserGender("男");}
//            else{addUser.setUserGender("女");}
//            addUser.setUserIdcard(188888888888888888L);
//            addUser.setUserType(random.nextInt(3));
//            addUser.setUserPassword("666666");
//            String familyName = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻水云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳鲍史唐费岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅卞齐康伍余元卜顾孟平"
//            + "黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计成戴宋茅庞熊纪舒屈项祝董粱杜阮席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田胡凌霍万柯卢莫房缪干解应宗丁宣邓郁单杭洪包诸左石崔吉"
//            +"龚程邢滑裴陆荣翁荀羊甄家封芮储靳邴松井富乌焦巴弓牧隗山谷车侯伊宁仇祖武符刘景詹束龙叶幸司韶黎乔苍双闻莘劳逄姬冉宰桂牛寿通边燕冀尚农温庄晏瞿茹习鱼容向古戈终居衡步都耿满弘国文东殴沃曾关红游盖益桓公晋楚闫";
//            String girlName = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽";
//            String boyName = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学";
//            int n1=random.nextInt(200);
//            int n2=random.nextInt(37);
//            int n3=random.nextInt(37);
//            int n4=random.nextInt(130);
//            int n5=random.nextInt(130);
//            String name1 = familyName.substring(n1,n1+1)+boyName.substring(n2,n2+1)+boyName.substring(n3,n3+1);
//            String name2 = familyName.substring(n1,n1+1)+girlName.substring(n4,n4+1)+girlName.substring(n5,n5+1);
//            if(i%2==0){addUser.setUserName(name1);}
//            else{addUser.setUserName(name2);}
//            addUser.setUserState(1);
//            addUser.setUserNumber(18888888888L);
//            System.err.println("adduser"+addUser.toString());
//            this.userService.insert(addUser);
//        }
//        Date date=new Date();
//        System.err.println("date:"+date);
        if (loginUser != null && loginUser.getUserPassword().equals(user.getUserPassword()) && loginUser.getUserType().equals(user.getUserType())) {
            loginUser.setUserPassword("");
            System.err.println("user"+loginUser.getUserDate());
            return DataResult.successByData(loginUser);


        } else {
            return DataResult.errByErrCode(100);
        }


    }
}
