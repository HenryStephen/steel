package com.bro.steel.utils;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @program: code
 * @description: 专门用于layui的表格数据
 * @author: Shaoqingyang
 * @create: 2019-07-04 14:32
 **/
public class ResponseList {
    /**
     * 返回码
     */
    private String code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 列表大小
     */
    private Long count;

    /**
     * 列表数据集合
     */
    private PageInfo<?> list;

    private List<?> data;

    public ResponseList fail(Exception e) {
        code = "1";
        msg = e.getMessage();
        return this;
    }

    public ResponseList success(PageInfo<?> t) {
        code = "0";
        msg = "成功";
        count = t.getTotal();
        data = t.getList();
        return this;
    }
    public ResponseList success(List<?> t) {
        code = "0";
        msg = "成功";
        count = Long.valueOf(t.size());
        data = t;
        return this;
    }
    public ResponseList success() {
        code = "0";
        msg = "成功";
        data = null;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public PageInfo<?> getList() {
        return list;
    }

    public void setList(PageInfo<?> list) {
        this.list = list;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
