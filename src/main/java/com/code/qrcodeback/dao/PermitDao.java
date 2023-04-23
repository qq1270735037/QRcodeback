package com.code.qrcodeback.dao;

import com.code.qrcodeback.entity.Permit;
import com.code.qrcodeback.link.PermitAndApply;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Permit)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-23 22:50:33
 */
public interface PermitDao {

    /**
     * 通过ID查询单条数据
     *
     * @param permitId 主键
     * @return 实例对象
     */
    Permit queryById(Integer permitId);

    /**
     * 查询指定行数据
     *
     * @param permit 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Permit> queryAllByLimit(Permit permit, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param permit 查询条件
     * @return 总行数
     */
    long count(Permit permit);

    /**
     * 新增数据
     *
     * @param permit 实例对象
     * @return 影响行数
     */
    int insert(Permit permit);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Permit> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Permit> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Permit> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Permit> entities);

    /**
     * 修改数据
     *
     * @param permit 实例对象
     * @return 影响行数
     */
    int update(Permit permit);

    /**
     * 通过主键删除数据
     *
     * @param permitId 主键
     * @return 影响行数
     */
    int deleteById(Integer permitId);

    List<PermitAndApply> queryAllPermitAndApply();
}

