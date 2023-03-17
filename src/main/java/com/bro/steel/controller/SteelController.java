package com.bro.steel.controller;

import com.bro.steel.service.SteelService;
import com.bro.steel.entity.TblSteelInfo;
import com.bro.steel.utils.ResponseList;
import com.bro.steel.utils.ServerResponse;
import com.bro.steel.vo.TblSteelInfoVo;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhanghonglin
 * @date 2020/12/14 19:15
 * @class SteelController
 * @description SteelController
 */

@RestController
public class SteelController {

    private Log log= LogFactory.getLog(this.getClass());

    @Resource
    private SteelService steelService;

    /**
     * 添加新货物
     * @author zhanghonglin
     */
    @RequestMapping(value = "/addNewProduct",method = RequestMethod.POST)
    public ServerResponse addProduct(TblSteelInfoVo tblSteelInfoVo){
        log.info("添加新货物");
        try{
            tblSteelInfoVo.setSteelStatus(1);//设置货物的状态为 启用
            boolean b = steelService.addNewProduct(tblSteelInfoVo);
            if(b==false)
               return ServerResponse.createByErrorMessage("已有当前货物或服务器出错");
        }catch (Exception e){
            log.error("服务器出错");
        }
        return ServerResponse.createBySuccessMessage("新货物添加成功");
    }
    /**
     * 添加已有的货物
     * @author zhanghonglin
     */
    @RequestMapping(value = "/addOldProduct",method = RequestMethod.POST)
    public ServerResponse inProduct(TblSteelInfoVo tblSteelInfoVo){
        log.info("对已有的货物添加");
        try{
          boolean b = steelService.addOldProduct(tblSteelInfoVo);
          if(b==false)
              return ServerResponse.createByErrorMessage("添加货物失败");
        }catch (Exception e){
            log.error("服务器出错");
        }
        return ServerResponse.createBySuccessMessage("货物添加成功");
    }
    /**
     * 减少已有的货物
     * @author  zhanghonglin
     */
    @RequestMapping(value = "/disOldProduct",method = RequestMethod.POST)
    public ServerResponse outProduct(TblSteelInfoVo tblSteelInfoVo){
        log.info("出货");
        try{
           boolean b = steelService.disOldProduct(tblSteelInfoVo);
           if(b==false)
               return ServerResponse.createByErrorMessage("出货失败");
        }catch (Exception e){
            log.error("服务器出错");
        }
        return ServerResponse.createBySuccessMessage("货物减少成功");
    }
    /**
     * 查看已有货物 或者搜索
     * @author zhanghonglin
     */
    @RequestMapping(value = "/selectProduct",method = RequestMethod.POST)
    @ResponseBody
    public ResponseList selectProducts(TblSteelInfo tblSteelInfo,Integer page,Integer limit){
         log.info("货物信息查看");
         PageInfo<TblSteelInfo> pageInfo = null;
         ResponseList responseList = new ResponseList();
         try{
             List list = steelService.selectProductMe(tblSteelInfo,page,limit);
             pageInfo = new PageInfo<>(list);
             responseList.success(pageInfo);
         }catch (Exception e){
             log.error("服务器出错");
         }
        return responseList;
    }

    /**
     * 修改钢材信息
     * @author zhanghonglin
    */
    @PostMapping("/updateSteel")
    @ResponseBody
    public ServerResponse updateSteel(TblSteelInfo tblSteelInfo){
        log.info("修改钢材信息");
        try{
            steelService.updateSteel(tblSteelInfo);
            return ServerResponse.createBySuccessMessage("修改钢材信息成功");
        } catch (Exception e) {
            log.error(e);
            return ServerResponse.createByErrorMessage("服务器出错");
        }
    }
}
