package com.bro.steel.dao.manual;

import com.bro.steel.entity.TblUserInfo;

/**
 * @author zhanghonglin
 * @date 2020/12/14 19:27
 * @class TblUserInfoDao
 * @description TblUserInfoDao
 */
public interface TblUserInfoDao {
    /**
     * 判断当前登录信息正确与否
     * @author zhanghonglin
     */
    TblUserInfo selectUser(TblUserInfo tblUserInfo);
}
