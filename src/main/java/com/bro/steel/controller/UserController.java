package com.bro.steel.controller;

import com.bro.steel.service.userService;
import com.bro.steel.entity.TblUserInfo;
import com.bro.steel.utils.ServerResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author zhanghonglin
 * @date 2020/12/14 19:24
 * @class UserController
 * @description UserController
 */
@Controller
public class UserController {

    private Log log= LogFactory.getLog(this.getClass());

    @Resource
    private userService userService;
    /**
     * 用户登录
     * 页面跳转前端进行
     * @author zhanghonglin
     */
    @ResponseBody
    @RequestMapping(value = "/loginControl" , method = RequestMethod.POST)
    public ServerResponse userLogin(TblUserInfo tblUserInfo, HttpSession session){
         log.info("用户登录");
         try{
              //调用service层判断
            boolean b = userService.loginService(tblUserInfo);
            if(b==false)
                return ServerResponse.createByErrorMessage("登录失败");
            System.out.println("登录成功");
         }catch (Exception e){
             log.error("服务器出错");
             return ServerResponse.createByErrorMessage("服务器错误");
         }
         session.setAttribute("user",tblUserInfo);
         return ServerResponse.createBySuccessMessage("登录成功");
    }

    @GetMapping(value = {"/","/admin","/login"})
    public String login(HttpSession session){
        log.info("跳转登录界面");
        TblUserInfo userInfo = (TblUserInfo)session.getAttribute("user");
        return userInfo == null ? "login" : "index";
    }

    @GetMapping("/index")
    public String index(HttpSession session){
        log.info("跳转主界面");
        TblUserInfo userInfo = (TblUserInfo)session.getAttribute("user");
        return userInfo == null ? "login" : "index";
    }
}
