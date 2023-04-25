package com.code.qrcodeback.service.impl;

import com.code.qrcodeback.entity.Fiximage;
import com.code.qrcodeback.dao.FiximageDao;
import com.code.qrcodeback.service.FiximageService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Fiximage)表服务实现类
 *
 * @author makejava
 * @since 2023-04-23 00:17:55
 */
@Service("fiximageService")
public class FiximageServiceImpl implements FiximageService {
    @Resource
    private FiximageDao fiximageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param imageId 主键
     * @return 实例对象
     */
    @Override
    public Fiximage queryById(Integer imageId) {
        return this.fiximageDao.queryById(imageId);
    }

    /**
     * 分页查询
     *
     * @param fiximage 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Fiximage> queryByPage(Fiximage fiximage, PageRequest pageRequest) {
        long total = this.fiximageDao.count(fiximage);
        return new PageImpl<>(this.fiximageDao.queryAllByLimit(fiximage, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param fiximage 实例对象
     * @return 实例对象
     */
    @Override
    public Fiximage insert(Fiximage fiximage) {
        this.fiximageDao.insert(fiximage);
        return fiximage;
    }

    /**
     * 修改数据
     *
     * @param fiximage 实例对象
     * @return 实例对象
     */
    @Override
    public Fiximage update(Fiximage fiximage) {
        this.fiximageDao.update(fiximage);
        return this.queryById(fiximage.getImageId());
    }

    /**
     * 通过主键删除数据
     *
     * @param imageId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer imageId) {
        return this.fiximageDao.deleteById(imageId) > 0;
    }

    @Override
    public List<Fiximage> queryByfixId(Integer fixId){
        return this.fiximageDao.queryByfixId(fixId);
    };

}
