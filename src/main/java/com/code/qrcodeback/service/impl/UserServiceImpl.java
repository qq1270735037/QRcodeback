package com.code.qrcodeback.service.impl;

import com.code.qrcodeback.entity.User;
import com.code.qrcodeback.dao.UserDao;
import com.code.qrcodeback.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2023-04-17 00:45:23
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer userId) {
        return this.userDao.queryById(userId);
    }


    @Override
    public List<User> queryByPage(Long Page,Long Limit) {

        return this.userDao.queryByPage( Page,Limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.userDao.deleteById(userId) > 0;
    }

    @Override
    public List<User> queryAll(){
        return this.userDao.queryAll();
    }

    @Override
    public long count(){return this.userDao.count();}

    @Override
    public List<User> searchById(Integer userId){
        return this.userDao.searchById(userId);
    }

    @Override
    public List<User> searchByName(String userName){
        return this.userDao.searchByName(userName);
    }

    @Override
    public List<User> searchByIdCard(String userIdcard){
        return this.userDao.searchByIdCard(userIdcard);
    }


}
