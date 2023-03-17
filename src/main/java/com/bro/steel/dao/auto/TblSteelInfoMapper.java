package com.bro.steel.dao.auto;

import com.bro.steel.entity.TblSteelInfo;

public interface TblSteelInfoMapper {
    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer sid);

    /**
     *
     * @mbg.generated
     */
    int insert(TblSteelInfo record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(TblSteelInfo record);

    /**
     *
     * @mbg.generated
     */
    TblSteelInfo selectByPrimaryKey(Integer sid);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TblSteelInfo record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TblSteelInfo record);
}