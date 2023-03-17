package com.bro.steel.dao.auto;

import com.bro.steel.entity.TblLogInfo;

public interface TblLogInfoMapper {
    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(TblLogInfo record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(TblLogInfo record);

    /**
     *
     * @mbg.generated
     */
    TblLogInfo selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TblLogInfo record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TblLogInfo record);
}