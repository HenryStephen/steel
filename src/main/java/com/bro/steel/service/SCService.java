package com.bro.steel.service;

import com.bro.steel.entity.TblSupplierInfo;

import java.util.List;

/**
 * @author zhanghonglin
 * @version 1.0
 * @date 2020/12/14 20:21
 */
public interface SCService {
    /**
     * 查看供应商或客户
     * @author zhanghonglin
     * @param tblSupplierInfo
     * @return
     */
    List selectSC(TblSupplierInfo tblSupplierInfo, Integer PageSize, Integer PageNum);

    /**
     * 列表查看供应商或客户
     * @author zhanghonglin
     * @param tblSupplierInfo
     * @return
     */
    List selectSC(TblSupplierInfo tblSupplierInfo);

    /**
     * 修改供应商或客户信息
     * @param tblSupplierInfo
     */
    void updateSC(TblSupplierInfo tblSupplierInfo);

    /**
     * 添加新供应商或客户
     * @param tblSupplierInfo
     * @return
     */
    boolean addNewSC(TblSupplierInfo tblSupplierInfo);

    /**
     * 删除供应商或客户
     * @param id
     * @return
     */
    boolean delSC(Integer id);
}
