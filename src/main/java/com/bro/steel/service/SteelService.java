package com.bro.steel.service;

import com.bro.steel.entity.TblSteelInfo;
import com.bro.steel.vo.TblSteelInfoVo;

import java.util.List;

/**
 * @author zhanghonglin
 * @date 2020/12/14 19:29
 * @class SteelService
 * @description SteelService
 */
public interface SteelService {
    /**
     * 添加新货物
     * @author zhanghonglin
     */
    boolean addNewProduct(TblSteelInfoVo tblSteelInfoVo);
    /**
     * 添加货物
     * @author zhanghonglin
     */
    boolean addOldProduct(TblSteelInfoVo tblSteelInfoVo);
    /**
     * 减少货物
     * @author zhanghonglin
     */
    boolean disOldProduct(TblSteelInfoVo tblSteelInfoVo);
    /**
     * 货物查看
     * @author zhanghonglin
     */
    List<TblSteelInfo> selectProductMe(TblSteelInfo tblSteelInfo, Integer PageSize, Integer PageNum);
    /**
     * 修改信息
     * @author zhanghonglin
     */
    void updateSteel(TblSteelInfo tblSteelInfo);
}
