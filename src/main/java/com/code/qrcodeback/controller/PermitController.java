package com.code.qrcodeback.controller;

import com.code.qrcodeback.entity.Permit;
import com.code.qrcodeback.entity.User;
import com.code.qrcodeback.link.PermitAndApply;
import com.code.qrcodeback.service.PermitService;
import com.code.qrcodeback.service.UserService;
import com.code.qrcodeback.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Permit)表控制层
 *
 * @author makejava
 * @since 2023-04-23 22:50:32
 */
@RestController
@RequestMapping("permit")
public class PermitController {
    /**
     * 服务对象
     */
    @Resource
    private PermitService permitService;
    @Resource
    private UserService userService;
    /**
     * 分页查询
     *
     * @param permit 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Permit>> queryByPage(Permit permit, PageRequest pageRequest) {
        return ResponseEntity.ok(this.permitService.queryByPage(permit, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Permit> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.permitService.queryById(id));
    }


    @PostMapping("/add")
    public DataResult add(@RequestBody PermitAndApply permitAndApply) {
        System.err.println("permitAndApply:"+permitAndApply.toString());
        Permit permit = new Permit();
        permit.setPermitState(permitAndApply.getPermitState());
        permit.setApplyId(permitAndApply.getApplyId());
        permit.setPermitTime(permitAndApply.getPermitTime());
        permitService.insert(permit);
        if(permit.getPermitState().equals(1)){
            User user =new User();
            user.setUserId(permitAndApply.getApplyUser());
            user.setUserState(1);
            userService.update(user);
        }
        return DataResult.errByErrCode(100);
    }

    /**
     * 编辑数据
     *
     * @param permit 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Permit> edit(Permit permit) {
        return ResponseEntity.ok(this.permitService.update(permit));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.permitService.deleteById(id));
    }

    @GetMapping("/searchPermit")
    public List<PermitAndApply> searchPermit(){

        return permitService.queryByPermitAndApplyId();
    }

    @PostMapping("/searchAllPermit")
    public List<PermitAndApply> searchAllPermit(@RequestBody PermitAndApply permitAndApply){

        return permitService.queryAllPermitAndApply(permitAndApply);
    }

    @PostMapping("/searchAllPermitById")
    public List<PermitAndApply> searchAllPermitById(@RequestBody PermitAndApply permitAndApply){
        System.err.println(permitAndApply);
        return permitService.queryByIdPermitAndApply(permitAndApply);
    }
}

