package com.code.qrcodeback.service;

import com.code.qrcodeback.entity.Fix;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Fix)表服务接口
 *
 * @author makejava
 * @since 2023-04-06 16:11:11
 */
public interface FixService {

    /**
     * 通过ID查询单条数据
     *
     * @param fixId 主键
     * @return 实例对象
     */
    Fix queryById(Integer fixId);

    /**
     * 分页查询
     *
     * @param fix 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Fix> queryByPage(Fix fix, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param fix 实例对象
     * @return 实例对象
     */
    Fix insert(Fix fix);

    /**
     * 修改数据
     *
     * @param fix 实例对象
     * @return 实例对象
     */
    Fix update(Fix fix);

    /**
     * 通过主键删除数据
     *
     * @param fixId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer fixId);

}
