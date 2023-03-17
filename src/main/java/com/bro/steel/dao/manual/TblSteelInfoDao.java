package com.bro.steel.dao.manual;

import com.bro.steel.entity.TblSteelInfo;
import com.bro.steel.vo.TblSteelInfoVo;

import java.util.List;

/**
 * @author zhanghonglin
 * @date 2020/12/14 19:27
 * @class TblSteelInfoDao
 * @description TblSteelInfoDao
 */
public interface TblSteelInfoDao {
    /**
     * 根据 货物名称 查看是否有此货物
     * @author zhanghonglin
     */
    TblSteelInfo selectSteelByName(TblSteelInfo tblSteelInfo);
    /**
     *对已有的货物进行添加
     * 同时对吨数进行修改
     * @author zhanghonglin
     */
    int addOldProduct(TblSteelInfoVo tblSteelInfoVo);
    /**
     * 已有货物减少 卖出货物
     * 同时对吨数进行修改
     * @author zhanghonglin
     */
    int disOldProduct(TblSteelInfo tblSteelInfo);
    /**
     * 查看已有的货物信息
     * 按照姓名字母顺讯返回
     * @author zhanghonglin
     */
    List<TblSteelInfo> selectList(TblSteelInfo tblSteelInfo);
}
