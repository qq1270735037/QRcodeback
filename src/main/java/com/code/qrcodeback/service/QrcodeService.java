package com.code.qrcodeback.service;

import com.code.qrcodeback.entity.Qrcode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Qrcode)表服务接口
 *
 * @author makejava
 * @since 2023-04-06 16:11:11
 */
public interface QrcodeService {

    /**
     * 通过ID查询单条数据
     *
     * @param codeId 主键
     * @return 实例对象
     */
    Qrcode queryById(Integer codeId);

    /**
     * 分页查询
     *
     * @param qrcode 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Qrcode> queryByPage(Qrcode qrcode, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param qrcode 实例对象
     * @return 实例对象
     */
    Qrcode insert(Qrcode qrcode);

    /**
     * 修改数据
     *
     * @param qrcode 实例对象
     * @return 实例对象
     */
    Qrcode update(Qrcode qrcode);

    /**
     * 通过主键删除数据
     *
     * @param codeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer codeId);

}
