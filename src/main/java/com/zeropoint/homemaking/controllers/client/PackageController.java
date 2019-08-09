package com.zeropoint.homemaking.controllers.client;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zeropoint.homemaking.domain.ServicePackage;
import com.zeropoint.homemaking.domain.UserPackage;
import com.zeropoint.homemaking.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

/**
 *  套餐卡
 * @author chowhin
 *
 */
@RestController
@RequestMapping("api/package")
public class PackageController {

    @Autowired
    PackageService packageService;
    /**
     *  套餐卡列表
     * @param request
     *
     * @return
     */
    @RequestMapping("/list")
    public JSONObject getPackageList(@RequestBody JSONObject request){
        JSONObject res=new JSONObject();
        System.out.println(request.toJSONString());
        try{
            List<ServicePackage> packages=packageService.getPackageList();
            res.put("code",1);
            res.put("msg","package list");
            res.put("data",packages);
        }catch (NullPointerException e){
            res.put("code",0);
            res.put("msg","");
        }
        System.out.println(res);
        return res;
    }

    /**
     *  套餐卡详情
     * @param request
     * @return
     */
    @RequestMapping("/packageInfo")
    public JSONObject getPackageInfo(@RequestBody JSONObject request){
        JSONObject res=new JSONObject();
        System.out.println(request.toJSONString());
        try{
            Integer packageId=request.getInteger("packageId");
            Integer userId=request.getInteger("userId");
            String token=request.getString("token");
            ServicePackage servicePackage=packageService.packageInfo(packageId);
            res.put("code",1);
            res.put("msg","packageInfo");
            res.put("data",servicePackage);

        }catch (NullPointerException e)
        {
            res.put("code",0);
            res.put("msg","");

        }
        System.out.println(res.toJSONString());
        return res;
    }
    /**
     *  用户套餐卡包
     * @param request  userId;
     * @return   list
     */
    @RequestMapping("/myPackages")
    public JSONObject myPackages(@RequestBody JSONObject request){
        JSONObject res=new JSONObject();
        System.out.println(request.toJSONString());
        try{
            Integer userId=request.getInteger("userId");
            List<UserPackage> myPackages=packageService.myPackages(userId);
            res.put("code",1);
            res.put("msg","myPackage");
            res.put("data",myPackages);

        }catch (NullPointerException e)
        {
            res.put("code",1);
            res.put("msg","myPackage");
        }catch (Exception e)
        {
            res.put("code",0);
            res.put("msg","");
        }
        System.out.println(res.toJSONString());
        return  res;
    }
    /**
     * 用户套餐卡详情
     * @param request userId,packageId
     * @return userPackage
     */
    @RequestMapping("/myPackageInfo")
    public JSONObject myPackageInfo(@RequestBody JSONObject request){
        JSONObject res=new JSONObject();
        try{
            Integer userId=request.getInteger("userId");
            String  token=request.getString("token");
            Integer packageId=request.getInteger("packageId");
            UserPackage userPackage=packageService.myPackageInfo(userId,packageId);
            res.put("code",1);
            res.put("msg","myPackageInfo");
            res.put("data",userPackage);

        }catch (NullPointerException e)
        {

        }catch (Exception e)
        {
            res.put("code",0);
            res.put("msg","");

        }
        System.out.println(res.toJSONString());
        return res;
    }

}
