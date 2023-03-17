package com.bro.steel.entity;

import java.util.Date;

/**
 * @author zhanghonglin
 * @date 2020/12/14 16:03
 * @class TblLogInfo
 * @description 记录出库入库信息
 */
public class TblLogInfo {
    /**
     * 进出货物日志表主键
     */
    private Integer id;

    /**
     * 操作项目名称 【1. 新增货物 2.进货 3.出货 4.删除货物】
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
     * 钢材进价或者钢材售价
     */
    private Double money;
    /**
     * 钢材操作吨数
     */
    private Double ton;

    /**
     * 操作时间
     */
    private Date operatorTime;

    /**
     * 客户或者供应商id
     */
    private Integer suId;

    /**
     * 进出货物日志表主键
     * @return id 进出货物日志表主键
     */

    public Integer getId() {
        return id;
    }

    /**
     * 进出货物日志表主键
     * @param id 进出货物日志表主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 操作项目名称 【1. 新增货物 2.进货 3.卖货 4.删除货物】
     * @return operator_name 操作项目名称 【1. 新增货物 2.进货 3.卖货 4.删除货物】
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 操作项目名称 【1. 新增货物 2.进货 3.卖货 4.删除货物】
     * @param operatorName 操作项目名称 【1. 新增货物 2.进货 3.卖货 4.删除货物】
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    /**
     * 钢材名称
     * @return name 钢材名称
     */
    public String getName() {
        return name;
    }

    /**
     * 钢材名称
     * @param name 钢材名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 钢材种类【单位】 kg
     * @return type 钢材种类【单位】 kg
     */
    public Double getType() {
        return type;
    }

    /**
     * 钢材种类【单位】 kg
     * @param type 钢材种类【单位】 kg
     */
    public void setType(Double type) {
        this.type = type;
    }

    /**
     * 钢材数量 【根】
     * @return num 钢材数量 【根】
     */
    public Double getNum() {
        return num;
    }

    /**
     * 钢材数量 【根】
     * @param num 钢材数量 【根】
     */
    public void setNum(Double num) {
        this.num = num;
    }

    /**
     * 进价或者售价
     * @return
     */
    public Double getMoney() {
        return money;
    }

    /**
     * 进价或者售价
     * @param money
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * 吨
     * @return
     */
    public Double getTon() {
        return ton;
    }

    /**
     * 吨
     * @param ton
     */
    public void setTon(Double ton) {
        this.ton = ton;
    }

    /**
     * 操作时间
     * @return operator_time 操作时间
     */
    public Date getOperatorTime() {
        return operatorTime;
    }

    /**
     * 操作时间
     * @param operatorTime 操作时间
     */
    public void setOperatorTime(Date operatorTime) {
        this.operatorTime = operatorTime;
    }

    /**
     * 供应商或客户id
     * @return
     */
    public Integer getSuId() {
        return suId;
    }

    /**
     * 供应商或客户id
     * @param suId
     */
    public void setSuId(Integer suId) {
        this.suId = suId;
    }
}