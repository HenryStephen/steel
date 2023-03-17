package com.bro.steel;

import com.bro.steel.service.SteelService;
import com.bro.steel.service.userService;
import com.bro.steel.dao.manual.TblLogInfoDao;
import com.bro.steel.dao.manual.TblSteelInfoDao;
import com.bro.steel.entity.TblSteelInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SteelApplicationTests {

    @Resource
    private userService userService;
    @Resource
    private SteelService steelService;
    @Resource
    private TblSteelInfoDao tblSteelInfoDao;
    @Resource
    private TblLogInfoDao tblLogInfoDao;
    @Test
    public void contextLoads() {
//        TblSteelInfo tblSteelInfo=new TblSteelInfo();
//        tblSteelInfo.setSteelNum(200.0);
//        tblSteelInfo.setSteelName("钢板12");
//        tblSteelInfo.setSteelType(56.0);
//        tblSteelInfo.setSteelInMoney(1400.0);
//        tblSteelInfo.setSteelDescription("唐山建龙钢材");
//        steelService.addNewProduct(tblSteelInfo);
//        TblLogInfoVo tblLogInfoVo = new TblLogInfoVo();
//        Calendar calendar1=Calendar.getInstance();
//        Calendar calendar2=Calendar.getInstance();
//        calendar1.set(2019, 7, 29);
//        calendar2.set(2019, 8, 29);
//        Date date=calendar1.getTime();
//        Date date1=calendar2.getTime();
//        tblLogInfoVo.setPreviousTime(date);
//        tblLogInfoVo.setEndTime(date1);
//        List<TblLogInfoVo> list = tblLogInfoDao.selectLogList(tblLogInfoVo);
//        System.out.println(list.size());
//        for(TblLogInfoVo rm : tblLogInfoDao.selectLogList(tblLogInfoVo)){
//            System.out.println(rm.getName());
//        }
    }

}
