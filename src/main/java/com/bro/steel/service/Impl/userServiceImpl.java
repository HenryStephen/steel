package com.bro.steel.service.Impl;

import com.bro.steel.service.userService;
import com.bro.steel.dao.auto.TblUserInfoMapper;
import com.bro.steel.dao.manual.TblUserInfoDao;
import com.bro.steel.entity.TblUserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhanghonglin
 * @date 2020/12/14 19:28
 * @class userServiceImpl
 * @description userServiceImpl
 */
@Service
public class userServiceImpl implements userService {

     @Resource
     private TblUserInfoMapper tblUserInfoMapper;

     @Resource
     private TblUserInfoDao tblUserInfoDao;
    /**
     * 判断登录信息正确与否
     * @author zhanghonglin
     * @param tblUserInfo
     * @return
     */
    @Override
    public boolean loginService(TblUserInfo tblUserInfo) {
        TblUserInfo tblUserInfo1=tblUserInfoDao.selectUser(tblUserInfo);
        if(tblUserInfo1==null)
            return false;
        else
            return true;
    }
}
