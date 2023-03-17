package com.bro.steel.dao.manual;

import com.bro.steel.entity.TblSteelInfo;
import com.bro.steel.entity.TblSupplierInfo;

import java.util.List;

/**
 * @author zhanghonglin
 * @version 1.0
 * @date 2020/12/14 20:34
 */
public interface TblSupplierInfoDao {

    /**
     * 查看供应商或客户
     * 按照姓名字母顺讯返回
     * @author zhanghonglin
     */
    List<TblSupplierInfo> selectList(TblSupplierInfo tblSupplierInfo);

    /**
     * 查看是否有重复的供应商或客户
     * @param tblSupplierInfo
     * @return
     */
    TblSupplierInfo selectSCByName(TblSupplierInfo tblSupplierInfo);
}
