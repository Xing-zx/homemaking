package com.zeropoint.homemaking.controllers.admin;

import com.zeropoint.homemaking.domain.Admin;
import com.zeropoint.homemaking.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  admin Controller
 *  后台全局控制器
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

    /** 管理员列表
     * @return   the list
     */
    @RequestMapping("/list")
    public List<Admin> listAdmin(@RequestParam("name") String name, @RequestParam("role") String role, @RequestParam("startTime") String startTime, @RequestParam("endTime") String endTime){
        Map<String,String> condition=new HashMap<>(16);
        condition.put("name",name);
        condition.put("role",role);
        condition.put("startTime",startTime);
        condition.put("endTime",endTime);
        return adminService.selectAll(condition);
    }

    /** 添加管理员
     * @param admin admin
     * @return status
     */
    @RequestMapping("/add")
    public String add(@RequestBody  Admin admin){
        return adminService.add(admin);
    }





 }
