package com.code.qrcodeback.controller;

import com.code.qrcodeback.entity.Permit;
import com.code.qrcodeback.service.PermitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    /**
     * 新增数据
     *
     * @param permit 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Permit> add(Permit permit) {
        return ResponseEntity.ok(this.permitService.insert(permit));
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

}

