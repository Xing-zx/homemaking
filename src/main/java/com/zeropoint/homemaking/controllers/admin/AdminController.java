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

    @RequestMapping("/adminInfo")
    public String  getAdminInfo(Principal principal){
      return principal.getName();
    }






 }
