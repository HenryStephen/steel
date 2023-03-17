package com.bro.steel.entity;

/**
 * @author zhanghonglin
 * @date 2020/12/14 16:05
 * @class TblSteelInfo
 * @description 记录钢材信息
 */
public class TblSteelInfo {

    /**
     * 钢材信息主键【所有信息】
     */
    private Integer sid;

    /**
     * 钢材名称
     */
    private String steelName;

    /**
     * 钢材的类型 【单位】kg
     */
    private Double steelType;

    /**
     * 钢材的数量【单位】 根
     */
    private Double steelNum;

    /**
     * 钢材的吨位【单位】 吨
     */
    private Double steelTon;

    /**
     * 进货价钱 【单位】元/kg
     */
    private Double steelInMoney;

    /**
     * 货物状态【1.启用 2.未启用】
     */
    private Integer steelStatus;

    /**
     * 钢材信息描述
     */
    private String steelDescription;


    /**
     * 钢材信息主键【所有信息】
     * @return sid 钢材信息主键【所有信息】
     */
    public Integer getSid() {
        return sid;
    }

    /**
     * 钢材信息主键【所有信息】
     * @param sid 钢材信息主键【所有信息】
     */
    public void setSid(Integer sid) {
        this.sid = sid;
    }

    /**
     * 钢材名称
     * @return steel_name 钢材名称
     */
    public String getSteelName() {
        return steelName;
    }

    /**
     * 钢材名称
     * @param steelName 钢材名称
     */
    public void setSteelName(String steelName) {
        this.steelName = steelName == null ? null : steelName.trim();
    }

    /**
     * 钢材的类型 【单位】kg
     * @return steel_type 钢材的类型 【单位】kg
     */
    public Double getSteelType() {
        return steelType;
    }

    /**
     * 钢材的类型 【单位】kg
     * @param steelType 钢材的类型 【单位】kg
     */
    public void setSteelType(Double steelType) {
        this.steelType = steelType;
    }

    /**
     * 钢材的数量【单位】 根
     * @return steel_num 钢材的数量【单位】 根
     */
    public Double getSteelNum() {
        return steelNum;
    }

    /**
     * 钢材的数量【单位】 根
     * @param steelNum 钢材的数量【单位】 根
     */
    public void setSteelNum(Double steelNum) {
        this.steelNum = steelNum;
    }

    /**
     * 钢材的吨位【单位】 吨
     * @return steel_ton 钢材的吨位【单位】 吨
     */
    public Double getSteelTon() {
        return steelTon;
    }

    /**
     * 钢材的吨位【单位】 吨
     * @param steelTon 钢材的吨位【单位】 吨
     */
    public void setSteelTon(Double steelTon) {
        this.steelTon = steelTon;
    }

    /**
     * 进货价钱 【单位】元
     * @return steel_in_money 进货价钱 【单位】元
     */
    public Double getSteelInMoney() {
        return steelInMoney;
    }

    /**
     * 进货价钱 【单位】元
     * @param steelInMoney 进货价钱 【单位】元
     */
    public void setSteelInMoney(Double steelInMoney) {
        this.steelInMoney = steelInMoney;
    }

    /**
     * 货物状态【1.启用 2.未启用】
     * @return steel_status 货物状态【1.启用 2.未启用】
     */
    public Integer getSteelStatus() {
        return steelStatus;
    }

    /**
     * 货物状态【1.启用 2.未启用】
     * @param steelStatus 货物状态【1.启用 2.未启用】
     */
    public void setSteelStatus(Integer steelStatus) {
        this.steelStatus = steelStatus;
    }

    /**
     * 钢材信息描述
     * @return
     */
    public String getSteelDescription() {
        return steelDescription;
    }

    /**
     * 钢材信息描述
     * @param steelDescription
     */
    public void setSteelDescription(String steelDescription) {
        this.steelDescription = steelDescription;
    }

    @Override
    public String toString() {
        return "TblSteelInfo{" +
                "sid=" + sid +
                ", steelName='" + steelName + '\'' +
                ", steelType=" + steelType +
                ", steelNum=" + steelNum +
                ", steelTon=" + steelTon +
                ", steelInMoney=" + steelInMoney +
                ", steelStatus=" + steelStatus +
                ", steelDescription='" + steelDescription + '\'' +
                '}';
    }
}