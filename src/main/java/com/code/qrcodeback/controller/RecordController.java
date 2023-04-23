package com.code.qrcodeback.controller;

import com.code.qrcodeback.entity.Record;
import com.code.qrcodeback.service.RecordService;
import com.code.qrcodeback.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * (Record)表控制层
 *
 * @author makejava
 * @since 2023-04-06 16:11:11
 */

@RestController
@RequestMapping("record")
public class RecordController {
    /**
     * 服务对象
     */
    @Resource
    private RecordService recordService;

    /**
     * 分页查询
     *
     * @param record 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Record>> queryByPage(Record record, PageRequest pageRequest) {
        return ResponseEntity.ok(this.recordService.queryByPage(record, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Record> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.recordService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param record 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Record> add(Record record) {
        return ResponseEntity.ok(this.recordService.insert(record));
    }

    /**
     * 编辑数据
     *
     * @param record 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Record> edit(Record record) {
        return ResponseEntity.ok(this.recordService.update(record));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.recordService.deleteById(id));
    }
//   记录插入
    @PostMapping("/insert" )
    public DataResult insert(@RequestBody Record record, HttpSession session) throws ParseException {
        System.err.println("record:" + record.toString());
        if(record!=null) {
            System.err.println(record.toString());
            recordService.insert(record);
            return DataResult.succ();
        }
        else{
            return DataResult.errByErrCode(101);
        }

    }

}

