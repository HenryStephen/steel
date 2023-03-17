package com.bro.steel.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author zhanghonglin
 * @date 2020/12/14 19:30
 * @class TblLogInfoVo
 * @description TblLogInfoVo
 */
@Data
@ToString
public class TblLogInfoVo {
    /**
     * 进出货物日志表主键
     */
    private Integer id;
    /**
     * 操作吨数
     */
    private Double ton;
    /**
     * 进货价格
     */
    private Double money;
    /**
     * 操作项目名称 【1. 新增货物 2.进货 3.卖货 4.删除货物】
     */
    private String operatorName;

    /**
     * 钢材名称
     */
    private String name;

    /**
     * 钢材种类【单位】 kg
     */
    private Double type;

    /**
     * 钢材数量 【根】
     */
    private Double num;

    /**
     * 供货商、客户Id
     */
    private Integer suId;

    /**
     * 供应商、客户姓名
     */
    private String suName;

    /**
     * 操作时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date operatorTime;
    /**
     * 开始日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date previousTime;
    /**
     * 截止日期
     */
    private Date endTime;

}
