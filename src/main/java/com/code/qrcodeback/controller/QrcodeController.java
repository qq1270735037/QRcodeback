package com.code.qrcodeback.controller;

import com.code.qrcodeback.entity.Qrcode;
import com.code.qrcodeback.service.QrcodeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Qrcode)表控制层
 *
 * @author makejava
 * @since 2023-04-06 16:11:11
 */
@RestController
@RequestMapping("qrcode")
public class QrcodeController {
    /**
     * 服务对象
     */
    @Resource
    private QrcodeService qrcodeService;

    /**
     * 分页查询
     *
     * @param qrcode 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Qrcode>> queryByPage(Qrcode qrcode, PageRequest pageRequest) {
        return ResponseEntity.ok(this.qrcodeService.queryByPage(qrcode, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Qrcode> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.qrcodeService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param qrcode 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Qrcode> add(Qrcode qrcode) {
        return ResponseEntity.ok(this.qrcodeService.insert(qrcode));
    }

    /**
     * 编辑数据
     *
     * @param qrcode 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Qrcode> edit(Qrcode qrcode) {
        return ResponseEntity.ok(this.qrcodeService.update(qrcode));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.qrcodeService.deleteById(id));
    }

}

