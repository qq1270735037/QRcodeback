package com.code.qrcodeback.controller;

import com.code.qrcodeback.entity.Record;
import com.code.qrcodeback.entity.User;
import com.code.qrcodeback.service.RecordService;
import com.code.qrcodeback.service.UserService;
import com.code.qrcodeback.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2023-04-15 21:25:44
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    private RecordService recordService;
    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userService.queryByPage(user, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public DataResult edit(@RequestBody User user) {
        System.err.println("user"+user.toString());
        User changeUser =userService.queryById(user.getUserId());
        if (changeUser != null ) {
//            changeUser.setUserName(user.getUserName());
//            System.err.println("user"+changeUser.toString());
            userService.update(user);
            changeUser =userService.queryById(user.getUserId());
            changeUser.setUserPassword("");
            return DataResult.successByData(changeUser);


        } else {
            return DataResult.errByErrCode(100);
        }
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }


    //传回图片
    @GetMapping("/image")
    public String image (@RequestParam("userImage") String userImage,HttpServletResponse response)throws ParseException {
        System.err.println("res:"+userImage);
        File file = new File(userImage );
        byte[] bytes = new byte[1024];
        try (OutputStream os = response.getOutputStream();
             FileInputStream fis = new FileInputStream(file)){
            while ((fis.read(bytes)) != -1) {
                os.write(bytes);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
    //   出行记录查询
    @PostMapping("/travel" )
    public DataResult insert(@RequestBody User user, HttpSession session) throws ParseException {
        System.err.println("user:" + user.toString());

            return DataResult.errByErrCode(101);


    }
}

