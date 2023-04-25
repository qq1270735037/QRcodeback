package com.code.qrcodeback.controller;

import com.alibaba.fastjson.JSONObject;
import com.code.qrcodeback.entity.Apply;
import com.code.qrcodeback.entity.Fix;
import com.code.qrcodeback.entity.User;
import com.code.qrcodeback.link.UserAndApply;
import com.code.qrcodeback.service.ApplyService;
import com.code.qrcodeback.service.UserService;
import com.code.qrcodeback.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * (Apply)表控制层
 *
 * @author makejava
 * @since 2023-04-06 16:11:11
 */
@RestController
@RequestMapping("apply")
public class ApplyController {
    /**
     * 服务对象
     */
    @Resource
    private ApplyService applyService;
    private UserService userService;
    /**
     * 分页查询
     *
     * @param apply 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Apply>> queryByPage(Apply apply, PageRequest pageRequest) {
        return ResponseEntity.ok(this.applyService.queryByPage(apply, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Apply> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.applyService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param apply 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Apply> add(Apply apply) {
        return ResponseEntity.ok(this.applyService.insert(apply));
    }

    /**
     * 编辑数据
     *
     * @param apply 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public DataResult edit(@RequestBody Apply apply) {
        System.err.println("apply:"+apply.toString());
        Apply changeApply =applyService.queryById(apply.getApplyId());
        if (changeApply != null ) {

            applyService.update(apply);
            changeApply =applyService.queryById(apply.getApplyId());

            return DataResult.successByData(changeApply);


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
        return ResponseEntity.ok(this.applyService.deleteById(id));
    }

    //    申请列表
    @PostMapping("search")
    public DataResult search() {
        List<UserAndApply> a = applyService.queryAllUserAndApply();
        //先排序时间后逆序
        Collections.sort(a, Comparator.comparing(UserAndApply::getApplyTime).reversed());
        //根据状态排序
        Comparator<UserAndApply> comparator = Comparator.comparing(UserAndApply::getApplyState);
        a.sort(comparator);
        for (int i = 0; i < a.size(); i++) {
            System.err.println(a.get(i).toString());
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("All",a);
        return DataResult.successByMessage("ok",jsonObject);
    }
}

