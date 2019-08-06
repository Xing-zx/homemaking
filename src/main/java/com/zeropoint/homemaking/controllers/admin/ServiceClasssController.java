package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.ServiceClassification;
import com.zeropoint.homemaking.services.ServiceClassificationsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/serviceclass")
public class ServiceClasssController {

    @Autowired
    private ServiceClassificationsService serviceclas;

    @RequestMapping("/serviceclasslist")
    public List<ServiceClassification> serviceClassLIst(){
        System.out.println("进入");
        return serviceclas.selectAll1();
    }

    /** 修改状态
     *
     * @return status
     */
    @RequestMapping ("/updatestatus")
    @ResponseBody
    public int UpdateAdmins(@Param(value="id")int id, @Param(value="status")int status){
        System.out.println(id+"------------------------------------"+status);
        return serviceclas.updateStatus1(id,status);
    }

    /** 删除/批量删除
     *
     * @return status
     */
    @RequestMapping ("/delete")
    @ResponseBody
    public void delete(@RequestParam(value="ids")Integer[] ids){
        System.out.println(ids+"------------------------------------");
        serviceclas.delete1(ids);
    }

    @RequestMapping("/selectPage")
    public Map<String,Object> selectPage(@RequestParam("curr")Integer curr, @RequestParam("limit") Integer limit){
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<ServiceClassification> adminlist=serviceclas.selectPage1(page,limit);

        int count=serviceclas.count1();
        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "数据返回成功");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", count);
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", adminlist);
        //返回给前端

        String json= JSONObject.toJSONString(tableData);
        System.out.println(json);
        return tableData;
    }

    @RequestMapping("/insert")
    public int insert(@RequestBody JSONObject json){
        ServiceClassification service =new ServiceClassification();
        service.setIconUrl(json.getString("img"));
        service.setArticleId(json.getInteger("articleId"));
        service.setIntroduced(json.getString("url"));
        service.setName(json.getString("name"));
        service.setStatus(json.getInteger("status"));
        return serviceclas.insert1(service);
    }

    @RequestMapping("/update")
    public int update(@RequestBody JSONObject json){
        ServiceClassification service =new ServiceClassification();
        service.setId(json.getInteger("id"));
        service.setIconUrl(json.getString("img"));
        service.setArticleId(json.getInteger("articleId"));
        service.setIntroduced(json.getString("url"));
        service.setName(json.getString("name"));
        service.setStatus(json.getInteger("status"));
        return serviceclas.updateByPrimaryKey1(service);
    }

    @RequestMapping("/selectKey")
    public ServiceClassification selectKey(@RequestParam("id")Integer id){
        return serviceclas.selectByPrimaryKey1(id);
    }
}
