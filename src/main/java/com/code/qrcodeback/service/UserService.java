package com.code.qrcodeback.service;

import com.code.qrcodeback.entity.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2023-04-17 00:45:23
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Integer userId);


    List<User> queryByPage(Long Page,Long Limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

    List<User> queryAll();

    long count();

    List<User> searchById(Integer userId);

    List<User> searchByName(String userName);

    List<User> searchByIdCard(String userIdcard);
}
