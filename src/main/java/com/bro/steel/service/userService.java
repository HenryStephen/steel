package com.bro.steel.service;

import com.bro.steel.entity.TblUserInfo;

/**
 * @author zhanghonglin
 * @date 2020/12/14 19:29
 * @class userService
 * @description userService
 */
public interface userService {

    /**
     * 判断用户登录信息
     * @author zhanghonglin
     */
    boolean loginService(TblUserInfo tblUserInfo);
}
