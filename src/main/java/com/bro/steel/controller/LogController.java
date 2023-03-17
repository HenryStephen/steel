package com.bro.steel.controller;

import com.bro.steel.service.LogService;
import com.bro.steel.entity.TblLogInfo;
import com.bro.steel.utils.DateUtil;
import com.bro.steel.utils.ResponseList;
import com.bro.steel.utils.ServerResponse;
import com.bro.steel.vo.TblLogInfoVo;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;

/**
 * @author zhanghonglin
 * @date 2020/12/14 19:24
 * @class LogController
 * @description LogController
 */
@Controller
public class LogController {

    private Log log = LogFactory.getLog(this.getClass());

    @Resource
    private LogService logService;
    /**
     * 对日志信息的查看 信息的搜索
     * @author zhanghonglin
     */
    @PostMapping("/selectLog")
    @ResponseBody
    public ResponseList selectLog(String operatorName,String name,String type,String money,String operatorTime,String previousTime,Integer page,Integer limit){
        log.info("查看日志");
        TblLogInfoVo tblLogInfoVo = new TblLogInfoVo();
        tblLogInfoVo.setOperatorName(operatorName);
        tblLogInfoVo.setName(name);
        if(!StringUtils.isEmpty(type)){
            tblLogInfoVo.setType(Double.valueOf(type));
        }
        if(!StringUtils.isEmpty(money)){
            tblLogInfoVo.setMoney(Double.valueOf(money));
        }
        try {
            if(!StringUtils.isEmpty(operatorTime)){
                tblLogInfoVo.setOperatorTime(DateUtil.stringToDate(operatorTime,DateUtil.YYYY_MM_DD_HH_MM_SS));
            }
            if(!StringUtils.isEmpty(previousTime)){
                tblLogInfoVo.setPreviousTime(DateUtil.stringToDate(previousTime,DateUtil.YYYY_MM_DD_HH_MM_SS));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PageInfo<TblLogInfoVo> pageInfo = null;
        ResponseList responseList=new ResponseList();
        try{
         pageInfo=logService.selectLog(tblLogInfoVo, page, limit);
         responseList.success(pageInfo);
        }catch (Exception e){
         log.error("服务器出错");
        }
        return responseList;
    }
    /**
     * 删除日志信息
     * @Author zhanghonglin
     */
    @RequestMapping(value = "/deleteLog",method = RequestMethod.POST)
    public ServerResponse deleteLog(TblLogInfo tblLogInfo){
        log.info("删除日志信息");
        try{
          boolean  b = logService.deleteLogOld(tblLogInfo);
          if(b==false) return ServerResponse.createByErrorMessage("删除日志信息失败");
        }catch (Exception e){
            log.error("服务器出错");
        }
        return ServerResponse.createBySuccessMessage("删除日志信息成功");
    }
}
