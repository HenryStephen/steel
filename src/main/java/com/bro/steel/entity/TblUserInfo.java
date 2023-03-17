package com.bro.steel.entity;

import java.util.Date;

/**
 * @author zhanghonglin
 * @date 2020/12/14 16:21
 * @class TblUserInfo
 * @description 描述用户信息
 */
public class TblUserInfo {
    /**
     * 用户表主键id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 用户表主键id
     * @return id 用户表主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 用户表主键id
     * @param id 用户表主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户名
     * @return user_name 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 用户密码
     * @return password 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 用户密码
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 创建日期
     * @return create_date 创建日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建日期
     * @param createDate 创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}