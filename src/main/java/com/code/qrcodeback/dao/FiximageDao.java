package com.code.qrcodeback.dao;

import com.code.qrcodeback.entity.Fiximage;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Fiximage)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-23 00:17:55
 */
public interface FiximageDao {

    /**
     * 通过ID查询单条数据
     *
     * @param imageId 主键
     * @return 实例对象
     */
    Fiximage queryById(Integer imageId);

    /**
     * 查询指定行数据
     *
     * @param fiximage 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Fiximage> queryAllByLimit(Fiximage fiximage, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param fiximage 查询条件
     * @return 总行数
     */
    long count(Fiximage fiximage);

    /**
     * 新增数据
     *
     * @param fiximage 实例对象
     * @return 影响行数
     */
    int insert(Fiximage fiximage);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Fiximage> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Fiximage> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Fiximage> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Fiximage> entities);

    /**
     * 修改数据
     *
     * @param fiximage 实例对象
     * @return 影响行数
     */
    int update(Fiximage fiximage);

    /**
     * 通过主键删除数据
     *
     * @param imageId 主键
     * @return 影响行数
     */
    int deleteById(Integer imageId);

}

