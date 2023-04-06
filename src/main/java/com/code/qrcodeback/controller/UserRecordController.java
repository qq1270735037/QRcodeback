package com.code.qrcodeback.controller;

import com.code.qrcodeback.entity.UserRecord;
import com.code.qrcodeback.service.UserRecordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserRecord)表控制层
 *
 * @author makejava
 * @since 2023-04-06 16:11:12
 */
@RestController
@RequestMapping("userRecord")
public class UserRecordController {
    /**
     * 服务对象
     */
    @Resource
    private UserRecordService userRecordService;

    /**
     * 分页查询
     *
     * @param userRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<UserRecord>> queryByPage(UserRecord userRecord, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userRecordService.queryByPage(userRecord, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<UserRecord> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userRecordService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param userRecord 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<UserRecord> add(UserRecord userRecord) {
        return ResponseEntity.ok(this.userRecordService.insert(userRecord));
    }

    /**
     * 编辑数据
     *
     * @param userRecord 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<UserRecord> edit(UserRecord userRecord) {
        return ResponseEntity.ok(this.userRecordService.update(userRecord));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userRecordService.deleteById(id));
    }

}

