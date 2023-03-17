package com.bro.steel.utils;

//注意这里要导入com.fasterxml下的包忽略null才有效

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * response
 * 接口数据返回定义类
 * 作用:将需要返回给前端的数据进行包装，同时封装status和msg两个字段并JSON序列化
 * T(泛型) 为返回数据的类型
 */
@SuppressWarnings("deprecation")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)//保证序列化Json的时候，如果是null对象,key也会消失
public class ServerResponse<T> implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    //接口返回状态
    private int status;

    //返回提示信息
    private String msg;

    //返回的数据
    private T data;

    public static String redirect(String url, String object){
        return "redirect:redirect?html="+url+ "&param="+ object;
    }

    //私有构造参数，不允许外部直接调用
    private ServerResponse(int status){
        this.status = status;
    }

    private ServerResponse(int status,T data){
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    //保留字段，作为Controller判断请求是否成功的判断，不返回给前端
    @JsonIgnore
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    //根据成功与否及是否需要返回data提供的各种静态构造方法

    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDsc());
    }

    public static <T> ServerResponse<T> createByError(ResponseCode code){
        return new ServerResponse<T>(code.getCode(), code.getDsc());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String errorMsg){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMsg);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMsg){
        return new ServerResponse<T>(errorCode,errorMsg);
    }

    public static <T> ServerResponse<T> createByNeedLoginMessage(String errorMsg){
        return new ServerResponse<T>(ResponseCode.NEED_LOGIN.getCode(),errorMsg);
    }

}
