package com.code.qrcodeback.controller;

import com.alibaba.fastjson.JSONObject;
import com.code.qrcodeback.entity.Record;
import com.code.qrcodeback.entity.User;
import com.code.qrcodeback.link.RecordAndUser;
import com.code.qrcodeback.link.UserAndApply;
import com.code.qrcodeback.service.RecordService;
import com.code.qrcodeback.utils.result.DataResult;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    //    申请列表
    @PostMapping("searchByUserId")
    public DataResult search(@RequestBody Record record) {
        List<Record> a = recordService.searchById(record.getRecordUserId());
        //先排序时间后逆序
        Collections.sort(a, Comparator.comparing(Record::getBackTime).reversed());

        for (int i = 0; i < a.size(); i++) {
            System.err.println(a.get(i).toString());
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("All",a);
        return DataResult.successByMessage("ok",jsonObject);
    }

    //    全部记录列表
    @PostMapping("searchAll")
    public DataResult searchAll() {
        List<RecordAndUser> a = recordService.searchAll();
        //先排序时间后逆序
        Collections.sort(a, Comparator.comparing(RecordAndUser::getBackTime).reversed());

        for (int i = 0; i < a.size(); i++) {
//            System.err.println(a.get(i).toString());
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("All",a);
        return DataResult.successByMessage("ok",jsonObject);
    }
    //获取近七天日期
    public static List<String> getSevenDate() {

        List<String> dateList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < 7; i++) {

            Date date = DateUtils.addDays(new Date(), -i);
            String formatDate = sdf.format(date);
            dateList.add(formatDate);
        }
        return dateList;
    }

    //    7日记录列表
    @PostMapping("getSeven")
    public DataResult getSeven() throws ParseException {
        List<RecordAndUser> a = recordService.searchAll();
        //先排序时间后逆序
        Collections.sort(a, Comparator.comparing(RecordAndUser::getBackTime).reversed());
        Date date = new Date();

        List<Integer> cnt = new ArrayList<>();
        List<RecordAndUser> seven = new ArrayList<>();
        for (int i = 0; i < 7; i++) {

            cnt.add(0);
        }
        List<String> data = getSevenDate();
        Collections.reverse(data);
        System.err.println(data);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < a.size(); i++) {
            for (int k=0;k<7;k++){
                if(sdf.format(a.get(i).getBackTime()).contains(data.get(k))){
                    cnt.set(k,cnt.get(k)+1);
                    System.err.println(sdf.format(a.get(i).getBackTime()));
                    seven.add(a.get(i));
                }
            }

        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("cnt",cnt);
        jsonObject.put("data",data);
        jsonObject.put("seven",seven);


        for (int i = 0; i < 7; i++) {
            String formatDate = data.get(i).substring(5,10 );;
            data.set(i,formatDate);
        }

        return DataResult.successByMessage("ok", jsonObject);
    }

    //  通过id查
    @PostMapping("/searchAllById" )
    public DataResult searchAllById(@RequestBody RecordAndUser recordAndUser) {

        List<RecordAndUser> o = this.recordService.searchAllById(recordAndUser.getRecordUserId());
        for (int i = 0; i < o.size(); i++) {
            System.err.println(o.get(i).toString());
        }
        return DataResult.successByDataArray(o);


    }
    //  通过name查
    @PostMapping("/searchAllByName" )
    public DataResult searchAllByName(@RequestBody RecordAndUser recordAndUser) {

        List<RecordAndUser> o = this.recordService.searchAllByName(recordAndUser.getUserName());
        for (int i = 0; i < o.size(); i++) {
            System.err.println(o.get(i).toString());
        }
        return DataResult.successByDataArray(o);


    }
}

