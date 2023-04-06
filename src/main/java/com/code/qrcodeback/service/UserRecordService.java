package com.code.qrcodeback.service;

import com.code.qrcodeback.entity.UserRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (UserRecord)表服务接口
 *
 * @author makejava
 * @since 2023-04-06 16:11:12
 */
public interface UserRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    UserRecord queryById(Integer userId);

    /**
     * 分页查询
     *
     * @param userRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<UserRecord> queryByPage(UserRecord userRecord, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param userRecord 实例对象
     * @return 实例对象
     */
    UserRecord insert(UserRecord userRecord);

    /**
     * 修改数据
     *
     * @param userRecord 实例对象
     * @return 实例对象
     */
    UserRecord update(UserRecord userRecord);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

}
