package com.code.qrcodeback.service.impl;

import com.code.qrcodeback.entity.Fix;
import com.code.qrcodeback.dao.FixDao;
import com.code.qrcodeback.service.FixService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Fix)表服务实现类
 *
 * @author makejava
 * @since 2023-04-23 00:17:03
 */
@Service("fixService")
public class FixServiceImpl implements FixService {
    @Resource
    private FixDao fixDao;

    /**
     * 通过ID查询单条数据
     *
     * @param fixId 主键
     * @return 实例对象
     */
    @Override
    public Fix queryById(Integer fixId) {
        return this.fixDao.queryById(fixId);
    }

    /**
     * 分页查询
     *
     * @param fix 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Fix> queryByPage(Fix fix, PageRequest pageRequest) {
        long total = this.fixDao.count(fix);
        return new PageImpl<>(this.fixDao.queryAllByLimit(fix, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param fix 实例对象
     * @return 实例对象
     */
    @Override
    public Fix insert(Fix fix) {
        this.fixDao.insert(fix);
        return fix;
    }

    /**
     * 修改数据
     *
     * @param fix 实例对象
     * @return 实例对象
     */
    @Override
    public Fix update(Fix fix) {
        this.fixDao.update(fix);
        return this.queryById(fix.getFixId());
    }

    /**
     * 通过主键删除数据
     *
     * @param fixId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer fixId) {
        return this.fixDao.deleteById(fixId) > 0;
    }
}
