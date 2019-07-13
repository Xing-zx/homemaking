package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Admin;
import com.zeropoint.homemaking.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.JstlView;

import java.security.Principal;
import java.util.*;

/**
 *  admin Controller
 *  管理员控制器
 * @author zx
 * @date 2019-7-10 15:46
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /** 个人信息
     * @param principal
     * @return 账号信息
     */
    @RequestMapping("/adminInfo")
    public String  getAdminInfo(Principal principal){
      return principal.getName();
    }

    /** 管理员列表/查询
     * @return   the list
     */
    @RequestMapping("/list")
    public List<Admin> listAdmin(@RequestBody JSONObject conJson){
        System.out.println(conJson.toJSONString());
        Map<String,String> condition=new HashMap<>(16);
        condition.put("name",conJson.getString("name"));
        condition.put("role",conJson.getString("role"));
        condition.put("startTime",conJson.getString("startTime"));
        condition.put("endTime",conJson.getString("endTime"));
        return adminService.selectAll(condition);
    }

    /** 添加管理员
     * @param jsonObject admin
     * @return status
     */
    @RequestMapping("/add")
    public String add(@RequestBody JSONObject jsonObject){
        Admin admin=new Admin();
        admin.setName(jsonObject.getString("name"));
        admin.setPassword(jsonObject.getString("password"));
        admin.setPhone(jsonObject.getString("phone"));
        admin.setRole(jsonObject.getString("role"));
        admin.setStatus(jsonObject.getInteger("status"));
        admin.setRegisterTime(new Date());
        return adminService.add(admin);
    }

    /** 删除/批量删除
     * @param jsonObject 删除的ids
     * @return status
     */
    @RequestMapping ("/delete")
    public String delete(@RequestBody JSONObject jsonObject){
        Integer[] ids=new Integer[100];
        ((List<Integer>)jsonObject.get("data")).toArray(ids);
        return adminService.delete(ids);
    }





 }
