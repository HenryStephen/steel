package com.bro.steel.service.Impl;

import com.bro.steel.service.LogService;
import com.bro.steel.dao.auto.TblLogInfoMapper;
import com.bro.steel.dao.manual.TblLogInfoDao;
import com.bro.steel.entity.TblLogInfo;
import com.bro.steel.vo.TblLogInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhanghonglin
 * @date 2020/12/14 19:28
 * @class LogServiceImpl
 * @description LogServiceImpl
 */
@Service
public class LogServiceImpl implements LogService {

    @Resource
    private TblLogInfoDao tblLogInfoDao ;
    @Resource
    private TblLogInfoMapper tblLogInfoMapper;
    /**
     * 查看 搜索日志信息
     * @author zhanghonglin
     * @param tblLogInfoVo
     * @return
     */
    @Override
    public PageInfo<TblLogInfoVo> selectLog(TblLogInfoVo tblLogInfoVo,Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<TblLogInfoVo> list = tblLogInfoDao.selectLogList(tblLogInfoVo);
        if(list.size()==0) return null;
        return new PageInfo<TblLogInfoVo>(list);
    }

    /**
     * 删除日志信息
     * @author zhanghonglin
     * @param tblLogInfo
     * @return
     */
    @Override
    public boolean deleteLogOld(TblLogInfo tblLogInfo) {
        int a = tblLogInfoMapper.deleteByPrimaryKey(tblLogInfo.getId());
        if(a==0)
        return false;
        else
            return  true;
    }
}
