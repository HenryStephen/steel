package com.bro.steel.controller;

import com.bro.steel.entity.TblSteelInfo;
import com.bro.steel.entity.TblSupplierInfo;
import com.bro.steel.service.SCService;
import com.bro.steel.utils.ResponseList;
import com.bro.steel.utils.ServerResponse;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhanghonglin
 * @version 1.0
 * @date 2020/12/14 20:21
 */

@RestController
public class SCController {

    private Log log= LogFactory.getLog(this.getClass());

    @Resource
    private SCService scService;

    /**
     * 查看用供应商或客户 或者搜索
     * @author zhanghonglin
     */
    @RequestMapping(value = "/selectSC",method = RequestMethod.POST)
    @ResponseBody
    public ResponseList selectSupCli(TblSupplierInfo tblSupplierInfo, Integer page, Integer limit){
        log.info("查看供应商和客户信息");
        PageInfo<TblSupplierInfo> pageInfo = null;
        ResponseList responseList = new ResponseList();
        try{
            List list = scService.selectSC(tblSupplierInfo,page,limit);
            pageInfo = new PageInfo<>(list);
            responseList.success(pageInfo);
        }catch (Exception e){
            log.error("服务器出错");
        }
        return responseList;
    }
    /**
     * 查看用供应商或客户 或者搜索
     * @author zhanghonglin
     */
    @RequestMapping(value = "/selectSC",method = RequestMethod.GET)
    @ResponseBody
    public ResponseList selectSC(Integer type){
        log.info("列表查看供应商和客户信息");
        ResponseList responseList = new ResponseList();
        try{
            TblSupplierInfo tblSupplierInfo = new TblSupplierInfo();
            tblSupplierInfo.setType(type);
            List list = scService.selectSC(tblSupplierInfo);
            responseList.success(list);
        }catch (Exception e){
            log.error("服务器出错");
        }
        return responseList;
    }
    /**
     * 修改供应商或客户信息
     * @Author:zhanghonglin
     */
    @PostMapping("/updateSC")
    @ResponseBody
    public ServerResponse updateSC(TblSupplierInfo tblSupplierInfo){
        log.info("修改供应商或客户信息");
        try{
            scService.updateSC(tblSupplierInfo);
            return ServerResponse.createBySuccessMessage("修改供应商或客户信息成功");
        } catch (Exception e) {
            log.error(e);
            return ServerResponse.createByErrorMessage("服务器出错");
        }
    }

    /**
     * 添加新供应商或客户
     * @author zhanghonglin
     */
    @RequestMapping(value = "/addNewSC",method = RequestMethod.POST)
    public ServerResponse addSC(TblSupplierInfo tblSupplierInfo){
        log.info("添加新供应商或客户");
        try{
            boolean b = scService.addNewSC(tblSupplierInfo);
            if(b==false)
                return ServerResponse.createByErrorMessage("已有当前供应商或客户");
        }catch (Exception e){
            log.error("服务器出错");
        }
        return ServerResponse.createBySuccessMessage("添加成功");
    }

    /**
     * 删除供应商或用户
     * @author zhanghonglin
     */
    @RequestMapping(value = "/delSC",method = RequestMethod.POST)
    public ServerResponse delSC(Integer id){
        log.info("添加新货物");
        try{
            boolean b = scService.delSC(id);
            if(b==false)
                return ServerResponse.createByErrorMessage("供应商或客户有历史信息，无法删除");
        }catch (Exception e){
            log.error("服务器出错");
        }
        return ServerResponse.createBySuccessMessage("删除供应商或客户成功");
    }
}
