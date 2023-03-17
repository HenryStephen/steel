package com.bro.steel.controller;

import com.bro.steel.entity.TblUserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author zhanghonglin
 * @date 2020/12/14 19:26
 * @class ViewController
 * @description ViewController
 */
@Controller
public class ViewController {

    /**
     * 配置视图解析器
     * @author zhanghonglin
     */
    @RequestMapping(value = {"/view"})
    public String viewResolve(String url, HttpSession session){
        //此接口不能非法访问，需要用户登录
        TblUserInfo userInfo = (TblUserInfo)session.getAttribute("user");
        return userInfo == null ? "login" : url;
    }
}
