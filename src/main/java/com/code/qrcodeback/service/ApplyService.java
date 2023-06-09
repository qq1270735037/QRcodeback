package com.code.qrcodeback.service;

import com.code.qrcodeback.entity.Apply;
import com.code.qrcodeback.link.UserAndApply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Apply)表服务接口
 *
 * @author makejava
 * @since 2023-04-06 16:11:11
 */
public interface ApplyService {

    /**
     * 通过ID查询单条数据
     *
     * @param applyId 主键
     * @return 实例对象
     */
    Apply queryById(Integer applyId);

    /**
     * 分页查询
     *
     * @param apply 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Apply> queryByPage(Apply apply, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param apply 实例对象
     * @return 实例对象
     */
    Apply insert(Apply apply);

    /**
     * 修改数据
     *
     * @param apply 实例对象
     * @return 实例对象
     */
    Apply update(Apply apply);

    /**
     * 通过主键删除数据
     *
     * @param applyId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer applyId);

    List<UserAndApply> queryAllUserAndApply();
}
