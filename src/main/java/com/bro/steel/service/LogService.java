package com.bro.steel.service;

import com.bro.steel.entity.TblLogInfo;
import com.bro.steel.vo.TblLogInfoVo;
import com.github.pagehelper.PageInfo;

/**
 * @author zhanghonglin
 * @date 2020/12/14 19:28
 * @class LogService
 * @description LogService
 */
public interface LogService {
    /**
     * 对日志信息查看 搜索
     * @author zhanghonglin
     */
    PageInfo<TblLogInfoVo> selectLog(TblLogInfoVo tblLogInfoVo,Integer page,Integer limit);
    /**
     * 删除日志信息
     * Author zhanghonglin
     */
    boolean deleteLogOld(TblLogInfo tblLogInfo);
}
