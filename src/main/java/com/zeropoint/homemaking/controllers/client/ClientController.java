package com.zeropoint.homemaking.controllers.client;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeropoint.homemaking.annotation.PassToken;
import com.zeropoint.homemaking.domain.Article;
import com.zeropoint.homemaking.domain.Lecture;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.domain.User;
import com.zeropoint.homemaking.services.*;
import com.zeropoint.homemaking.utils.HttpUtil;
import com.zeropoint.homemaking.vo.ArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@RestController
public class ClientController {

    @Autowired
     private  HomeService homeService;
    @Autowired
    PersonnelService personnelService;
    @Autowired
    LectureService lectureService;
    @Autowired
    ArticleService articleService;
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    String sessionKey="";

    private String appId="wxff876a118beab366";

    private String appSecret="02667bd06fd0064f43482e7ddf6dffda";

    private String grantType="authorization_code";


   // private String requestUrl="https://api.weixin.qq.com/sns/jscode2session";

    private String code="";


    /** 主页信息填充和链接
     * @return
     */
    @RequestMapping("/home")
    public JSONObject getHome(){
         System.out.println("receive request");
        JSONObject res = new JSONObject();
        res.put("code",1);
        res.put("msg","home");
        Map< String ,Object> wrapper =new HashMap<>(16);
        wrapper.put("menu",homeService.getMenu());
        wrapper.put("swiper",homeService.getSwiper());
        wrapper.put("speciality",personnelService.getChildList("特长"));
        wrapper.put("certificate",personnelService.getChildList("证书"));
        res.put("data", wrapper);
        return  res;
    }

    /**
     *  用户登录
     * @param request 登录请求
     * @return 返回 登录信息
     */
    @PassToken
    @RequestMapping("/userLogin")
    public JSONObject login(@RequestBody JSONObject request){

        JSONObject res = new JSONObject();
        String url = "https://api.weixin.qq.com/sns/jscode2session" + "?appid=" + appId + "&secret=" + appSecret + "&js_code=" + request.getString("code") + "&grant_type="
               + grantType;
        System.out.println("url"+url);
        String data = HttpUtil.get(url);
        System.out.println("data"+data);
        JSONObject params=JSONObject.parseObject(data);
        String openId=params.getString("openid");
        sessionKey =params.getString("session_key");
        res.put("code",1);
        res.put("msg","login");
        Integer id;
        if (userService.selectByOpenId(openId)== null)
        {
            User user =new User();
            user.setNickName(request.getString("nickName"));
            user.setAddress(request.getString("country")+request.getString("province")+request.getString("city"));
            user.setPortraitUrl(request.getString("avatarUrl"));
            user.setGender(request.getInteger("gender"));
            user.setOpenId(openId);
            userService.Add(user);
            request.put("id",userService.selectByOpenId(openId));
            request.put("code",openId);
            request.put("phone","");
            request.put("token",tokenService.getToken(user));
            res.put("data",request);
            return res;
        }

        res.put("data",userService.selectByOpenId(openId));
        return res;
    }

    /**
     * 获取电话号码
     * @param request
     * @return
     */
    @RequestMapping("/getPhone")
    public JSONObject getPhone(@RequestBody JSONObject request){
        System.out.println(request.toJSONString());
        JSONObject res = new JSONObject();
//        String url = this.requestUrl + "?appid=" + appId + "&secret=" + appSecret + "&js_code=" + request.getString("code") + "&grant_type="
//                + grantType;
//        String data = HttpUtil.get(url);
//        JSONObject params=JSONObject.parseObject(data);
//       // sessionKey= params.getString("session_key");
//        System.out.println(data);
        res.put("code",1);
        res.put("msg","phone");
        res.put("data",homeService.decryptData(request.getString("encryptedData"),request.getString("iv"),sessionKey));
        System.out.println(res.toJSONString());
        return res;
    }

    /**
     *  手机号/短信验证
     * @param request
     * @return
     */
    @RequestMapping("/message")
    public JSONObject messageAC(@RequestBody JSONObject request){
        JSONObject res =new JSONObject();
        System.out.println(request.toJSONString());
        User user=userService.findUserByPhone(request.getString("phone"));
        if(user==null)
        {
            code =HomeService.verifyCode();
            JSONObject respone=homeService.senSms(request.getString("phone"),code);
            System.out.println(respone.toJSONString());
            res.put("code",1);
            res.put("msg","发送成功");
        }
        res.put("code",1);
        res.put("msg","已注册");
        return res;
    }

    /** 注册
     * @param request
     * @return
     */
    @RequestMapping("/register")
    public JSONObject register(@RequestBody JSONObject request){
        JSONObject res = new JSONObject();
        User user=new User();
        user.setPhone(request.getString("phone"));
        user.setPassword(request.getString("password"));
        userService.Add(user);
        user =userService.findUserByPhone(request.getString("phone"));
        res.put("code",1);
        res.put("msg","register");
        res.put("data",user);
        return res;
    }






}
