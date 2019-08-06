package com.zeropoint.homemaking.controllers.client;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.JsonObject;
import com.zeropoint.homemaking.dao.UserMapper;
import com.zeropoint.homemaking.domain.Certificate;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.domain.Speciality;
import com.zeropoint.homemaking.domain.User;
import com.zeropoint.homemaking.services.HomeService;
import com.zeropoint.homemaking.services.PersonnelService;
import com.zeropoint.homemaking.services.TokenService;
import com.zeropoint.homemaking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    HomeService homeService;
    @Autowired
    PersonnelService personnelService;
    String code;
    @RequestMapping("/sms")
    public JSONObject sendSms(@RequestBody JSONObject request, HttpServletRequest http){
        JSONObject res =new JSONObject();
        //验证token
       if (TokenService.authToken(request.getString("token"),userService.findUserById(request.getInteger("id"))))
       {
           code =HomeService.verifyCode();
           http.getSession().setAttribute("code",code);
           res.put("code",1);
           res.put("msg", homeService.senSms(request.getString("phone"),code));
         return res;
       }
       res.put("code",0);
       res.put("msg","token 不匹配");
       return res;
    }

    @RequestMapping("/identify")
    public JSONObject identify(@RequestBody JSONObject request,HttpServletRequest http){
        JSONObject res =new JSONObject();
        if (TokenService.authToken(request.getString("token"),userService.findUserById(request.getInteger("id"))))
        {
           if(request.getString("code").equals(code))
           {
            res.put("code",1);
            res.put("msg","success");
            return  res;
           }
        }
        res.put("code",0);
        res.put("msg","认证失败");
        return res;
    }

    @RequestMapping("/editPassword")
    public JSONObject editPassword(@RequestBody JSONObject request){
        JSONObject res =new JSONObject();
        Integer id=request.getInteger("id");
        User user = userService.findUserById(id);

        if (user != null)
        {
            user.setPassword(request.getString("password"));
            res.put("code",1);
            res.put("msg",userService.update(user));
            res.put("data",0);
            return res;

        }
        res.put("code",1);
        res.put("msg","该用户不存在");
        return res;
    }
    @RequestMapping("/editPhone")
    public JSONObject editPhoneNumber(@RequestBody JSONObject request){
        JSONObject res =new JSONObject();
        Integer id=request.getInteger("id");
        User user = userService.findUserById(id);
        if (user != null) {
            if (TokenService.authToken(request.getString("token"), user)) {
                if (request.getString("code").equals(code)) {

                        user.setPhone(request.getString("phone"));
                        res.put("code", 1);
                        res.put("msg", userService.update(user));
                        res.put("data", 0);
                        return res;
                }
            }
        }
        res.put("code",0);
        res.put("msg","修改失败");
        return res;
    }
    @RequestMapping("/info")
    public JSONObject info(@RequestBody JSONObject request){
        JSONObject res = new JSONObject();
        Integer id=request.getInteger("id");
        String  token=request.getString("token");
        System.out.println(request.toJSONString());
        try{
            User user= userService.findUserById(id);
            if(token.equals(TokenService.getToken(user))) {
                res.put("code", 1);
                res.put("msg", "info");
                user.setStatus(personnelService.findByUserId(user.getId()).getStatus());
                res.put("data", user);
            }
            else
            {
                res.put("code",0);
                res.put("msg","token is invaild");
            }

        }catch (NullPointerException e)
        {
            res.put("code",0);
            res.put("msg","用户信息——用户不存在");

        }
        return res;
    }

    /**
     *  查看阿姨
     * @param request {id}
     * @return
     * workType:1	//1月嫂 2保姆 3钟点工
     * 	photosrc:''	//头像
     * 	name		//真实姓+称户 '刘阿姨'
     * 	age		//年龄
     * 	score		//评分
     * 	price:80	//如果是终点工则表示 80/小时，其它的工人则无意义
     * 	expirence	//工作经验
     * 	address		//籍贯
     * 	city:'',	//城市
     * 	special:['跳舞','插花'],	//特长
     * 	education:['健康证','培训证'],	//持有证件  证件需要后台审核过了才能显示
     * 	videosrc:'',	//视频
     * 	intro	:'',	//自我 介绍
     */
    @RequestMapping("/viewPersonnel")
    public JSONObject viewPersonnel(@RequestBody JSONObject request){
        JSONObject res =new JSONObject();
         Integer id =request.getInteger("id");
         res.put("code",1);
         res.put("msg","view personnel");
        ServicePersonnel personnel =personnelService.findById(id);
        if( personnel.getStatus()!= 2)
        {
            res.put("code",0);
            res.put("msg","阿姨未审核");
         return res;
        }
        List<String> specialities =personnelService.getSpecialityName(personnel.getId());
        if(specialities !=null)
        {
            personnel.setSpecialities(specialities);
        }
        List<String> certificates =personnelService.getCertificateName(personnel.getId());
        if(certificates !=null)
        {
            personnel.setCertificates(certificates);
        }

        res.put("data",personnel);
        System.out.println(res);
        return res;
    }
}
