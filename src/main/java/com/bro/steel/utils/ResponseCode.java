package com.bro.steel.utils;

/**
 * @author zhanghonglin
 * @date 2020/12/14 19:29
 * @class ResponseCode
 * @description ResponseCode
 */
/**
 * 返回status
 * 枚举类，接口处理状态code和description
 */
public enum ResponseCode {
    SUCCESS(1,"SUCCESS"),
    ERROR(0,"ERROR"),
    NEED_LOGIN(10,"用户未登录，请登录"),
    YES(1,"是"),
    NO(0,"否"),
    DELETE(2,"删除"),
    STOP(0,"禁用"),
    START(1,"启用"),
    //failure
    LOGIN_FAILURE(11, "登录失败！请重新登录"),
    EXIT(3,"退出"),
    ACC_DELETE(4,"删除");

    public final int code;
    public final String dsc;

    ResponseCode(int code, String dsc) {
        this.code = code;
        this.dsc = dsc;
    }

    public int getCode() {
        return code;
    }

    public String getDsc() {
        return dsc;
    }

}
