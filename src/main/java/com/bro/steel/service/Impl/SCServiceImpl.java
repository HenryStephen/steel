package com.bro.steel.service.Impl;

import com.bro.steel.dao.auto.TblLogInfoMapper;
import com.bro.steel.dao.auto.TblSteelInfoMapper;
import com.bro.steel.dao.auto.TblSupplierInfoMapper;
import com.bro.steel.dao.manual.TblLogInfoDao;
import com.bro.steel.dao.manual.TblSupplierInfoDao;
import com.bro.steel.entity.TblSteelInfo;
import com.bro.steel.entity.TblSupplierInfo;
import com.bro.steel.service.SCService;
import com.bro.steel.vo.TblLogInfoVo;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghonglin
 * @version 1.0
 * @date 2020/12/14 20:22
 */
@Service
public class SCServiceImpl implements SCService {

    @Resource
    private TblSupplierInfoDao tblSupplierInfoDao;

    @Resource
    private TblSupplierInfoMapper tblSupplierInfoMapper;

    @Resource
    private TblLogInfoDao tblLogInfoDao;

    /**
     * 查看供应商或客户
     * @param tblSupplierInfo
     * @param pageNum
     * @param pageSize
     * @return
     * @author zhanghonglin
     */
    @Override
    public List selectSC(TblSupplierInfo tblSupplierInfo, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TblSupplierInfo> list = tblSupplierInfoDao.selectList(tblSupplierInfo);
        return list;
    }

    /**
     * 列表查看供应商或客户
     * @param tblSupplierInfo
     * @return
     * @author zhanghonglin
     */
    @Override
    public List selectSC(TblSupplierInfo tblSupplierInfo) {
        List<TblSupplierInfo> list = tblSupplierInfoDao.selectList(tblSupplierInfo);
        return list;
    }

    /**
     * 修改供应商或客户信息
     * @param tblSupplierInfo
     */
    @Override
    public void updateSC(TblSupplierInfo tblSupplierInfo) {
        tblSupplierInfoMapper.updateByPrimaryKeySelective(tblSupplierInfo);
    }

    /**
     * 添加新供应商或客户
     * @param tblSupplierInfo
     * @return
     */
    @Override
    public boolean addNewSC(TblSupplierInfo tblSupplierInfo) {
        TblSupplierInfo tblSupplierInfo1= tblSupplierInfoDao.selectSCByName(tblSupplierInfo);
        //如果有当前货物返回无法添加新货物原因是已经有当前商品
        if(tblSupplierInfo1!=null)
        {
            System.out.println("有重复名称");
            return false;
        }
        int b = tblSupplierInfoMapper.insertSelective(tblSupplierInfo);
        if(b==0)
            return false;
        else
            return true;
    }

    /**
     * 删除供应商或客户
     * @param id
     * @return
     */
    @Override
    public boolean delSC(Integer id) {
        TblLogInfoVo tblLogInfoVo = new TblLogInfoVo();
        tblLogInfoVo.setSuId(id);
        List<TblLogInfoVo> logInfoVoList= tblLogInfoDao.selectLogList(tblLogInfoVo);
        //如果有当前货物返回无法添加新货物原因是已经有当前商品
        if(logInfoVoList!=null && logInfoVoList.size()!=0)
        {
            System.out.println("供应商或客户有历史信息，无法删除");
            return false;
        }
        int b = tblSupplierInfoMapper.deleteByPrimaryKey(id);
        if(b==0)
            return false;
        else
            return true;
    }
}
