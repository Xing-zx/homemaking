package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Admin;
import com.zeropoint.homemaking.domain.ServicePackage;
import com.zeropoint.homemaking.services.PackageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/package")
public class ServicePackageController {

    @Autowired
    private PackageService packageService;

    @RequestMapping("/list")
    public Map<String,Object> selectPage(@RequestParam("curr")Integer curr, @RequestParam("limit") Integer limit, @Param("name")String name, @Param("status")Integer status){
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<ServicePackage> adminlist=packageService.selectPage1(page,limit,name,status);

        int count=packageService.count1(name,status);
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

    @RequestMapping("/list1")
    public Map<String,Object> selectPage1(@RequestParam("type")Integer type){
        List<ServicePackage> adminlist=packageService.selectPage2(type);
        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "数据返回成功");
        //将全部数据的条数作为count传给前台（一共多少条）
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", adminlist);
        //返回给前端

        String json= JSONObject.toJSONString(tableData);
        System.out.println(json);
        return tableData;
    }

    @RequestMapping("/insert")
    public int insert(@RequestBody JSONObject json){
        Integer type=json.getInteger("types");
        System.out.println(type+"----------------------------------------");
        ServicePackage servicePackage=new ServicePackage();
        servicePackage.setImgSrc(json.getString("imgsrc"));
        servicePackage.setIntroduce(json.getString("introduce"));
        servicePackage.setName(json.getString("name"));
        servicePackage.setPrice(json.getDouble("price"));
        servicePackage.setStatus(1);
        servicePackage.setUseCount(json.getInteger("usecount"));
        servicePackage.setType(json.getInteger("types"));
        servicePackage.setSpecifications(json.getString("specifications"));
        servicePackage.setDetails(json.getString("details"));

        return packageService.insert(servicePackage);
    }

    @RequestMapping("/update")
    public int update(@RequestBody JSONObject json){

        ServicePackage servicePackage=new ServicePackage();
        servicePackage.setId(json.getInteger("id"));
        servicePackage.setImgSrc(json.getString("imgsrc"));
        servicePackage.setIntroduce(json.getString("introduce"));
        servicePackage.setName(json.getString("name"));
        servicePackage.setPrice(json.getDouble("price"));
        servicePackage.setStatus(1);
        servicePackage.setUseCount(json.getInteger("usecount"));
        servicePackage.setType(json.getInteger("types"));
        servicePackage.setSpecifications(json.getString("specifications"));
        servicePackage.setDetails(json.getString("details"));

        return packageService.updateByPrimaryKey(servicePackage);
    }

    @RequestMapping("/delete")
    public int delete(@RequestParam("ids")Integer[] ids){
        return packageService.delete(ids);
    }

    @RequestMapping("/selectKey")
    public ServicePackage selectKey(@RequestParam("id")Integer id){
        return packageService.selectByPrimaryKey(id);
    }

    @RequestMapping("/updateStatus")
    public int updateStatus(@RequestParam("id")Integer id,@RequestParam("status")Integer status){
        return packageService.updateStatus(id, status);
    }
}
