package com.code.qrcodeback.dao;

import com.code.qrcodeback.entity.Fix;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Fix)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-23 00:17:01
 */
public interface FixDao {

    /**
     * 通过ID查询单条数据
     *
     * @param fixId 主键
     * @return 实例对象
     */
    Fix queryById(Integer fixId);

    /**
     * 查询指定行数据
     *
     * @param fix 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Fix> queryAllByLimit(Fix fix, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param fix 查询条件
     * @return 总行数
     */
    long count(Fix fix);

    /**
     * 新增数据
     *
     * @param fix 实例对象
     * @return 影响行数
     */
    int insert(Fix fix);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Fix> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Fix> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Fix> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Fix> entities);

    /**
     * 修改数据
     *
     * @param fix 实例对象
     * @return 影响行数
     */
    int update(Fix fix);

    /**
     * 通过主键删除数据
     *
     * @param fixId 主键
     * @return 影响行数
     */
    int deleteById(Integer fixId);

}

