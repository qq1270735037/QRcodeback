package com.code.qrcodeback.service;

import com.code.qrcodeback.entity.Fiximage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Fiximage)表服务接口
 *
 * @author makejava
 * @since 2023-04-23 00:17:55
 */
public interface FiximageService {

    /**
     * 通过ID查询单条数据
     *
     * @param imageId 主键
     * @return 实例对象
     */
    Fiximage queryById(Integer imageId);

    /**
     * 分页查询
     *
     * @param fiximage 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Fiximage> queryByPage(Fiximage fiximage, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param fiximage 实例对象
     * @return 实例对象
     */
    Fiximage insert(Fiximage fiximage);

    /**
     * 修改数据
     *
     * @param fiximage 实例对象
     * @return 实例对象
     */
    Fiximage update(Fiximage fiximage);

    /**
     * 通过主键删除数据
     *
     * @param imageId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer imageId);

    List<Fiximage> queryByfixId(Integer fixId);
}
