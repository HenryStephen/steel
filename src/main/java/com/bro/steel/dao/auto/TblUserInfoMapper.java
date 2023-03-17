package com.bro.steel.dao.auto;

import com.bro.steel.entity.TblUserInfo;

public interface TblUserInfoMapper {
    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(TblUserInfo record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(TblUserInfo record);

    /**
     *
     * @mbg.generated
     */
    TblUserInfo selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TblUserInfo record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TblUserInfo record);
}