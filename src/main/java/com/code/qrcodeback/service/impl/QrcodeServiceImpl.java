package com.code.qrcodeback.service.impl;

import com.code.qrcodeback.entity.Qrcode;
import com.code.qrcodeback.dao.QrcodeDao;
import com.code.qrcodeback.service.QrcodeService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Qrcode)表服务实现类
 *
 * @author makejava
 * @since 2023-04-06 16:11:11
 */
@Service("qrcodeService")
public class QrcodeServiceImpl implements QrcodeService {
    @Resource
    private QrcodeDao qrcodeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param codeId 主键
     * @return 实例对象
     */
    @Override
    public Qrcode queryById(Integer codeId) {
        return this.qrcodeDao.queryById(codeId);
    }

    /**
     * 分页查询
     *
     * @param qrcode 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Qrcode> queryByPage(Qrcode qrcode, PageRequest pageRequest) {
        long total = this.qrcodeDao.count(qrcode);
        return new PageImpl<>(this.qrcodeDao.queryAllByLimit(qrcode, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param qrcode 实例对象
     * @return 实例对象
     */
    @Override
    public Qrcode insert(Qrcode qrcode) {
        this.qrcodeDao.insert(qrcode);
        return qrcode;
    }

    /**
     * 修改数据
     *
     * @param qrcode 实例对象
     * @return 实例对象
     */
    @Override
    public Qrcode update(Qrcode qrcode) {
        this.qrcodeDao.update(qrcode);
        return this.queryById(qrcode.getCodeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param codeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer codeId) {
        return this.qrcodeDao.deleteById(codeId) > 0;
    }
}
