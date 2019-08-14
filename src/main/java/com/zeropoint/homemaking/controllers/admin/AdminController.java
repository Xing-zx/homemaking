package com.zeropoint.homemaking.controllers.admin;


import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.config.WebConfigurer;
import com.zeropoint.homemaking.domain.Admin;
import com.zeropoint.homemaking.services.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    public String pulltest2(){
        return "pull";
    }


    /** 管理员列表/查询
     * @return   the list
     */
    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> listAdmin(@RequestParam("curr")Integer curr, @RequestParam("limit") Integer limit,
                                        @Param("name")String name, @Param("role")String role,
                                        @Param("endTime")String endTime, @Param("startTime")String startTime){
        System.out.println(name+"----------------------"+role+"----------------"+endTime+"---------------"+startTime);
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<Admin> adminlist=adminService.selectByCondition1(page,limit,name,role,endTime,startTime);

        int count=adminService.AdminCount1(name,role,endTime,startTime);
        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "数据返回成功");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", count);
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", adminlist);
        //返回给前端

        String json=JSONObject.toJSONString(tableData);
        System.out.println(json);
        return tableData;
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
        System.out.println(admin);
        return adminService.add(admin);
    }

    /** 删除/批量删除
     *
     * @return status
     */
    @RequestMapping ("/delete")
    @ResponseBody
    public void delete(@RequestParam(value="ids")Integer[] ids){
        System.out.println(ids+"------------------------------------");
        adminService.delete(ids);
    }

    /**
     *  更新
     * @return status
     */
    @RequestMapping("/update")
    public String update(@RequestBody JSONObject jsonObject){
        Admin admin=new Admin();
        admin.setId(jsonObject.getInteger("id"));
        admin.setName(jsonObject.getString("name"));
        admin.setPassword(jsonObject.getString("password"));
        admin.setPhone(jsonObject.getString("phone"));
        admin.setRole(jsonObject.getString("role"));
        admin.setStatus(jsonObject.getInteger("status"));
        admin.setRegisterTime(jsonObject.getDate("registerTime"));
        System.out.println(admin);
        return adminService.update(admin);
    }


    /** 修改状态
     *
     * @return status
     */
    @RequestMapping ("/updatestatus")
    @ResponseBody
    public int UpdateAdmins(@Param(value="id")int id, @Param(value="status")int status){
        System.out.println(id+"------------------------------------"+status);
        return adminService.updateStatus1(id,status);
    }

    @RequestMapping ("/selects")
    @ResponseBody
    public Admin selectByPrimaryKey(@RequestParam(value = "id")int id){
        System.out.println("进入");
        System.out.println(id+"+++++++++++++-----------------");
        return adminService.selectByPrimaryKey1(id);
    }

   @RequestMapping("/login")
    public Map<String,Object> login(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject json){
        System.out.println("--------------------------------");
        String str = "";
        String name=json.getString("name");
        String password=json.getString("password");
        System.out.println(name+"-------------------------"+password);
        Admin admin = new Admin();
        admin.setName(name);
        admin.setPassword(password);

       HttpSession session = request.getSession();
       //这里的User是登陆时放入session的
       session.setAttribute("admin",admin);
       Cookie c1 = new Cookie("loginName", name);
       c1.setPath("/");
       response.addCookie(c1);
       session.setAttribute("admin", WebConfigurer.SESSION_KEY);

        Map<String,Object> tableData =new HashMap<String,Object>();
        if(adminService.login1(admin)!=null){
            //这是layui要求返回的json数据格式
            tableData.put("code", 1);
            tableData.put("msg", "登录成功");
            //将全部数据的条数作为count传给前台（一共多少条）
            //将分页后的数据返回（每页要显示的数据）
            /*tableData.put("data", adminService.login1(admin));*/
            //返回给前端
        }else if(adminService.login1(admin)==null){
            tableData.put("code", 0);
            tableData.put("msg", "账号或密码不正确");
        }

       String jsons=JSONObject.toJSONString(tableData);
       System.out.println(jsons);
       return tableData;
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("admin");
    }
 }
