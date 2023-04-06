package com.code.qrcodeback.service;

import com.code.qrcodeback.entity.Ad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Ad)表服务接口
 *
 * @author makejava
 * @since 2023-04-06 16:11:07
 */
public interface AdService {

    /**
     * 通过ID查询单条数据
     *
     * @param adId 主键
     * @return 实例对象
     */
    Ad queryById(Integer adId);

    /**
     * 分页查询
     *
     * @param ad 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Ad> queryByPage(Ad ad, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param ad 实例对象
     * @return 实例对象
     */
    Ad insert(Ad ad);

    /**
     * 修改数据
     *
     * @param ad 实例对象
     * @return 实例对象
     */
    Ad update(Ad ad);

    /**
     * 通过主键删除数据
     *
     * @param adId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer adId);

}
