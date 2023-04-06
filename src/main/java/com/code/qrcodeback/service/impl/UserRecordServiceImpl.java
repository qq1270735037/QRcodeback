package com.code.qrcodeback.service.impl;

import com.code.qrcodeback.entity.UserRecord;
import com.code.qrcodeback.dao.UserRecordDao;
import com.code.qrcodeback.service.UserRecordService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (UserRecord)表服务实现类
 *
 * @author makejava
 * @since 2023-04-06 16:11:12
 */
@Service("userRecordService")
public class UserRecordServiceImpl implements UserRecordService {
    @Resource
    private UserRecordDao userRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public UserRecord queryById(Integer userId) {
        return this.userRecordDao.queryById(userId);
    }

    /**
     * 分页查询
     *
     * @param userRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<UserRecord> queryByPage(UserRecord userRecord, PageRequest pageRequest) {
        long total = this.userRecordDao.count(userRecord);
        return new PageImpl<>(this.userRecordDao.queryAllByLimit(userRecord, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param userRecord 实例对象
     * @return 实例对象
     */
    @Override
    public UserRecord insert(UserRecord userRecord) {
        this.userRecordDao.insert(userRecord);
        return userRecord;
    }

    /**
     * 修改数据
     *
     * @param userRecord 实例对象
     * @return 实例对象
     */
    @Override
    public UserRecord update(UserRecord userRecord) {
        this.userRecordDao.update(userRecord);
        return this.queryById(userRecord.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.userRecordDao.deleteById(userId) > 0;
    }
}
