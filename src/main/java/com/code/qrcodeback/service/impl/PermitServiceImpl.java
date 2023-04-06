package com.code.qrcodeback.service.impl;

import com.code.qrcodeback.entity.Permit;
import com.code.qrcodeback.dao.PermitDao;
import com.code.qrcodeback.service.PermitService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Permit)表服务实现类
 *
 * @author makejava
 * @since 2023-04-06 16:11:11
 */
@Service("permitService")
public class PermitServiceImpl implements PermitService {
    @Resource
    private PermitDao permitDao;

    /**
     * 通过ID查询单条数据
     *
     * @param permitId 主键
     * @return 实例对象
     */
    @Override
    public Permit queryById(Integer permitId) {
        return this.permitDao.queryById(permitId);
    }

    /**
     * 分页查询
     *
     * @param permit 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Permit> queryByPage(Permit permit, PageRequest pageRequest) {
        long total = this.permitDao.count(permit);
        return new PageImpl<>(this.permitDao.queryAllByLimit(permit, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param permit 实例对象
     * @return 实例对象
     */
    @Override
    public Permit insert(Permit permit) {
        this.permitDao.insert(permit);
        return permit;
    }

    /**
     * 修改数据
     *
     * @param permit 实例对象
     * @return 实例对象
     */
    @Override
    public Permit update(Permit permit) {
        this.permitDao.update(permit);
        return this.queryById(permit.getPermitId());
    }

    /**
     * 通过主键删除数据
     *
     * @param permitId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer permitId) {
        return this.permitDao.deleteById(permitId) > 0;
    }
}
