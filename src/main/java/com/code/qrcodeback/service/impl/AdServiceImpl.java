package com.code.qrcodeback.service.impl;

import com.code.qrcodeback.entity.Ad;
import com.code.qrcodeback.dao.AdDao;
import com.code.qrcodeback.link.FixAndUser;
import com.code.qrcodeback.service.AdService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Ad)表服务实现类
 *
 * @author makejava
 * @since 2023-04-06 16:11:08
 */
@Service("adService")
public class AdServiceImpl implements AdService {
    @Resource
    private AdDao adDao;

    /**
     * 通过ID查询单条数据
     *
     * @param adId 主键
     * @return 实例对象
     */
    @Override
    public Ad queryById(Integer adId) {
        return this.adDao.queryById(adId);
    }

    /**
     * 分页查询
     *
     * @param ad 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Ad> queryByPage(Ad ad, PageRequest pageRequest) {
        long total = this.adDao.count(ad);
        return new PageImpl<>(this.adDao.queryAllByLimit(ad, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param ad 实例对象
     * @return 实例对象
     */
    @Override
    public Ad insert(Ad ad) {
        this.adDao.insert(ad);
        return ad;
    }

    /**
     * 修改数据
     *
     * @param ad 实例对象
     * @return 实例对象
     */
    @Override
    public Ad update(Ad ad) {
        this.adDao.update(ad);
        return this.queryById(ad.getAdId());
    }

    /**
     * 通过主键删除数据
     *
     * @param adId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer adId) {
        return this.adDao.deleteById(adId) > 0;
    }


    @Override
    public List<Ad> searchAll(){
        return this.adDao.searchAll();
    }
}
