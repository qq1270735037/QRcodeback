package com.code.qrcodeback.dao;

import com.code.qrcodeback.entity.Ad;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Ad)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-06 16:10:55
 */
public interface AdDao {

    /**
     * 通过ID查询单条数据
     *
     * @param adId 主键
     * @return 实例对象
     */
    Ad queryById(Integer adId);

    /**
     * 查询指定行数据
     *
     * @param ad 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Ad> queryAllByLimit(Ad ad, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param ad 查询条件
     * @return 总行数
     */
    long count(Ad ad);

    /**
     * 新增数据
     *
     * @param ad 实例对象
     * @return 影响行数
     */
    int insert(Ad ad);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Ad> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Ad> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Ad> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Ad> entities);

    /**
     * 修改数据
     *
     * @param ad 实例对象
     * @return 影响行数
     */
    int update(Ad ad);

    /**
     * 通过主键删除数据
     *
     * @param adId 主键
     * @return 影响行数
     */
    int deleteById(Integer adId);

}

