package com.bro.steel.dao.manual;

import com.bro.steel.vo.TblLogInfoVo;

import java.util.List;

/**
 * @author zhanghonglin
 * @date 2020/12/14 19:21
 * @class TblLogInfoDao
 * @description TblLogInfoDao
 */
public interface TblLogInfoDao {
    /**
     * 查看或者搜索信息
     * @author zhanghonglin
     */
    List<TblLogInfoVo> selectLogList(TblLogInfoVo tblLogInfoVo);
    /**
     * 插入货物信息
     * @author zhanghonglin
     */
    int insertLog(TblLogInfoVo tblLogInfoVo);
}
