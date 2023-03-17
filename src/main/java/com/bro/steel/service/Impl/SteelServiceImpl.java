package com.bro.steel.service.Impl;

import com.bro.steel.service.SteelService;
import com.bro.steel.dao.auto.TblLogInfoMapper;
import com.bro.steel.dao.auto.TblSteelInfoMapper;
import com.bro.steel.dao.manual.TblLogInfoDao;
import com.bro.steel.dao.manual.TblSteelInfoDao;
import com.bro.steel.entity.TblLogInfo;
import com.bro.steel.entity.TblSteelInfo;
import com.bro.steel.vo.TblLogInfoVo;
import com.bro.steel.vo.TblSteelInfoVo;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghonglin
 * @date 2020/12/14 19:18
 * @class SteelServiceImpl
 * @description SteelServiceImpl
 */

@Service
public class SteelServiceImpl implements SteelService {

    @Resource
    private TblSteelInfoMapper tblSteelInfoMapper;

    @Resource
    private TblSteelInfoDao tblSteelInfoDao;

    @Resource
    private TblLogInfoMapper tblLogInfoMapper;

    @Resource
    private TblLogInfoDao tblLogInfoDao;
    /**
     * 添加新货物 & 对日志进行写操作
     * @author zhanghonglin
     * @param tblSteelInfoVo
     * @return
     */
    @Override
    public boolean addNewProduct(TblSteelInfoVo tblSteelInfoVo) {
        //将vo转换成entity
        TblSteelInfo tblSteelInfo = new TblSteelInfo();
        tblSteelInfo.setSteelName(tblSteelInfoVo.getSteelName());
        tblSteelInfo.setSteelType(tblSteelInfoVo.getSteelType());
        tblSteelInfo.setSteelInMoney(tblSteelInfoVo.getSteelInMoney());
        TblSteelInfo tblSteelInfo1= tblSteelInfoDao.selectSteelByName(tblSteelInfo);
        //如果有当前货物返回无法添加新货物原因是已经有当前商品
        if(tblSteelInfo1!=null)
        {
            System.out.println("有重复钢材");
            return false;
        }
        //求出总千克数
        double temp = tblSteelInfoVo.getSteelNum()*tblSteelInfoVo.getSteelType();
        //将千克数转换为吨数
        double steelTon= temp/1000.0;
        tblSteelInfoVo.setSteelTon(steelTon);
        //将信息放到日志里面去
        TblLogInfoVo tblLogInfoVo = new TblLogInfoVo();
        tblLogInfoVo.setTon(tblSteelInfoVo.getSteelTon());
        tblLogInfoVo.setMoney(tblSteelInfoVo.getSteelInMoney());
        tblLogInfoVo.setName(tblSteelInfoVo.getSteelName());
        tblLogInfoVo.setNum(tblSteelInfoVo.getSteelNum());
        tblLogInfoVo.setType(tblSteelInfoVo.getSteelType());
        tblLogInfoVo.setOperatorTime(new Date());
        tblLogInfoVo.setOperatorName("新货物入库");
        tblLogInfoVo.setTon(steelTon);
        tblLogInfoVo.setMoney(tblSteelInfoVo.getSteelInMoney());
        tblLogInfoVo.setSuId(tblSteelInfoVo.getSuId());
        int b = tblLogInfoDao.insertLog(tblLogInfoVo);
        if(b == 0)
            return false;
        int a =tblSteelInfoMapper.insertSelective(tblSteelInfoVo); //子类--->父类
        if(a == 0)
             return false;
        else
            return true;
    }

    /**
     * 添加已有的货物，进货 对日志进行写操作
     * @author zhanghonglin
     * @param tblSteelInfoVo
     * @return
     */
    @Override
    public boolean addOldProduct(TblSteelInfoVo tblSteelInfoVo) {
        //获取货物的kg数和吨数
        double temp = tblSteelInfoVo.getSteelType()*tblSteelInfoVo.getSteelNum();
        double ton = temp/1000;
        tblSteelInfoVo.setSteelTon(ton);
        //将信息放到日志里面去
        TblLogInfoVo tblLogInfoVo = new TblLogInfoVo();
        //找到原货物
        TblSteelInfo tblSteelInfo = tblSteelInfoMapper.selectByPrimaryKey(tblSteelInfoVo.getSid());
        tblLogInfoVo.setOperatorTime(new Date());
        tblLogInfoVo.setOperatorName("已有货物入库");
        tblLogInfoVo.setMoney(tblSteelInfoVo.getSteelInMoney());
        tblLogInfoVo.setName(tblSteelInfoVo.getSteelName());
        //计算进货数量
        tblLogInfoVo.setNum(tblSteelInfoVo.getSteelNum()-tblSteelInfo.getSteelNum());
        tblLogInfoVo.setType(tblSteelInfoVo.getSteelType());
        //计算进货吨数
        tblLogInfoVo.setTon(tblLogInfoVo.getNum()*tblLogInfoVo.getType()/1000.0);
        tblLogInfoVo.setMoney(tblSteelInfoVo.getSteelInMoney());
        tblLogInfoVo.setSuId(tblSteelInfoVo.getSuId());
        int b=tblLogInfoDao.insertLog(tblLogInfoVo);
        if(b==0)
            return false;
        int a = tblSteelInfoDao.addOldProduct(tblSteelInfoVo);
        if(a==0)    return false;
        else    return true;
    }

    /**
     * 减少已有的货物,卖货 对日志进行写操作
     * @author zhanghonglin
     * @param tblSteelInfoVo
     * @return
     */
    @Override
    public boolean disOldProduct(TblSteelInfoVo tblSteelInfoVo) {
        //获取货物的kg数和吨数
        double temp = tblSteelInfoVo.getSteelType()*tblSteelInfoVo.getSteelNum();
        double ton =temp/1000;
        tblSteelInfoVo.setSteelTon(ton);
        //将信息放到日志里面去
        TblLogInfoVo tblLogInfoVo = new TblLogInfoVo();
        TblSteelInfo tblSteelInfo1 = tblSteelInfoMapper.selectByPrimaryKey(tblSteelInfoVo.getSid());
        //防止单价修改
        tblSteelInfoVo.setSteelInMoney(tblSteelInfo1.getSteelInMoney());
        tblLogInfoVo.setOperatorTime(new Date());
        tblLogInfoVo.setOperatorName("出售货物");
        tblLogInfoVo.setTon(tblSteelInfoVo.getSteelTon());
        tblLogInfoVo.setMoney(tblSteelInfoVo.getSteelInMoney());
        tblLogInfoVo.setName(tblSteelInfoVo.getSteelName());
        //计算出货数量
        tblLogInfoVo.setNum(tblSteelInfo1.getSteelNum()-tblSteelInfoVo.getSteelNum());
        tblLogInfoVo.setType(tblSteelInfoVo.getSteelType());
        //计算出货吨数
        tblLogInfoVo.setTon(tblLogInfoVo.getNum()*tblLogInfoVo.getType()/1000.0);
        tblLogInfoVo.setMoney(tblSteelInfoVo.getSteelInMoney());
        tblLogInfoVo.setSuId(tblSteelInfoVo.getSuId());
        int b = tblLogInfoDao.insertLog(tblLogInfoVo);
        if(b==0)
            return false;
        int a = tblSteelInfoDao.disOldProduct(tblSteelInfoVo);
        if(a==0)
            return false;
        else
            return true;
    }

    /**
     * 对货物的查看和搜索
     * @author zhanghonglin
     * @param tblSteelInfo
     * @return
     */
    @Override
    public List<TblSteelInfo> selectProductMe(TblSteelInfo tblSteelInfo, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TblSteelInfo> list = tblSteelInfoDao.selectList(tblSteelInfo);
        return list;
    }

    /**
     * 修改货物信息
     * @author zhanghonglin
     * @param tblSteelInfo
     * @return
     */
    @Override
    public void updateSteel(TblSteelInfo tblSteelInfo) {
        tblSteelInfoMapper.updateByPrimaryKeySelective(tblSteelInfo);
    }
}
