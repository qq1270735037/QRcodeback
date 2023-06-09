package com.code.qrcodeback.service;

import com.code.qrcodeback.entity.Permit;
import com.code.qrcodeback.link.PermitAndApply;
import com.code.qrcodeback.link.UserAndApply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Permit)表服务接口
 *
 * @author makejava
 * @since 2023-04-23 22:50:34
 */
public interface PermitService {

    /**
     * 通过ID查询单条数据
     *
     * @param permitId 主键
     * @return 实例对象
     */
    Permit queryById(Integer permitId);

    /**
     * 分页查询
     *
     * @param permit 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Permit> queryByPage(Permit permit, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param permit 实例对象
     * @return 实例对象
     */
    Permit insert(Permit permit);

    /**
     * 修改数据
     *
     * @param permit 实例对象
     * @return 实例对象
     */
    Permit update(Permit permit);

    /**
     * 通过主键删除数据
     *
     * @param permitId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer permitId);

    List<PermitAndApply> queryByPermitAndApplyId();

    List<PermitAndApply> queryAllPermitAndApply(PermitAndApply permitAndApply);

    List<PermitAndApply> queryByIdPermitAndApply(PermitAndApply permitAndApply);
}
