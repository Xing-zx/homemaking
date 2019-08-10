package com.zeropoint.homemaking.controllers.client;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeropoint.homemaking.annotation.PassToken;
import com.zeropoint.homemaking.domain.*;
import com.zeropoint.homemaking.services.*;
import com.zeropoint.homemaking.utils.HttpUtil;
import com.zeropoint.homemaking.utils.QRcodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    HomeService homeService;
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
    @Autowired
    AddressService addressService;
    @Value("${file.uploadFolder}")
    private String uploadFolder;

    private String appId="wxff876a118beab366";

    private String appSecret="02667bd06fd0064f43482e7ddf6dffda";

    private String grantType="authorization_code";



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
     *  微信用户登录
     * @param request 登录请求
     * @return 返回 登录信息
     */
    @PassToken
    @RequestMapping("/userLogin")
    public JSONObject login(@RequestBody JSONObject request, HttpServletRequest http){
        System.out.println(request.toJSONString());
        HttpSession session =http.getSession();
        JSONObject res = new JSONObject();
        String url = "https://api.weixin.qq.com/sns/jscode2session" + "?appid=" + appId + "&secret=" + appSecret + "&js_code=" + request.getString("code") + "&grant_type="
               + grantType;
        String data = HttpUtil.get(url);
        JSONObject params=JSONObject.parseObject(data);
        String openId=params.getString("openid");
        Integer upline=request.getInteger("v_id");
        System.out.println(data);
        session.setAttribute("sessionKey",params.getString("session_key"));
        res.put("code",1);
        res.put("msg","login");
        User user1=  userService.selectByOpenId(openId);
        if (user1 == null&&openId !=null && openId != "")
        {
            User user =new User();
            user.setNickName(request.getString("nickName"));
            user.setName(request.getString("nickName"));
            user.setAddress(request.getString("country")+request.getString("province")+request.getString("city"));
            user.setPortraitUrl(request.getString("avatarUrl"));
            user.setGender(request.getInteger("gender"));
            user.setOpenId(openId);
            user.setCreateTime(new Date());
            if(upline !=null)
            {
                user.setUpline(upline);
                Integer upupline =userService.findUserById(upline).getUpline();
                if(upupline!=null)
                {
                    user.setUpupline(upupline);
                }
            }
            userService.Add(user);
            ServicePersonnel personnel =new ServicePersonnel(user);
            personnelService.addPersonnel(personnel);
            String accessToken=TokenService.getAccessToken();
            System.out.println(accessToken);
            String filename= QRcodeUtil.getminiqrQr(user.getId().toString(),accessToken,uploadFolder);
            if(filename !=null && filename !="")
            {
                filename = http.getScheme() + "://" + http.getServerName() + ":" + http.getServerPort() + "/" +filename;
            }
            user.setProgramCode(filename);
            userService.update(user);
            String token=TokenService.getToken(user);
            TokenService.sessionHashMap.put(token,session);
            res.put("data",user);
            return res;
        }
        else if(openId == null || openId == "")
        {
            res.put("code",0);
            res.put("msg","微信登录授权失败");
            return res;
        }
        else {
            ServicePersonnel personnel=personnelService.findByUserId(user1.getId());
            if(personnel==null)
            {
                personnel=new ServicePersonnel(user1);
                personnelService.addPersonnel(personnel);
            }
        }
        if (user1.getProgramCode() == null || user1.getProgramCode() =="")
        {
            System.out.println("programCode");
            String accessToken=TokenService.getAccessToken();
            System.out.println(accessToken);
           String filename= QRcodeUtil.getminiqrQr(user1.getId().toString(),accessToken,uploadFolder);
            if(filename !=null && filename !="")
            {
               filename = http.getScheme() + "://" + http.getServerName() + ":" + http.getServerPort() + "/" +filename;
            }
            user1.setProgramCode(filename);
            userService.update(user1);
        }
        res.put("data",user1);
        TokenService.sessionHashMap.put(user1.getToken(),session);
        System.out.println(res);
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
        HttpSession session=TokenService.sessionHashMap.get(request.getString("token"));
        String sessionKey;
        if(session==null)
        {
            String url = "https://api.weixin.qq.com/sns/jscode2session" + "?appid=" + appId + "&secret=" + appSecret + "&js_code=" + request.getString("code") + "&grant_type="
                    + grantType;
            String data = HttpUtil.get(url);
            sessionKey=JSONObject.parseObject(data).getString("session_key");


        }
        else
        {
            sessionKey= (String) session.getAttribute("sessionKey");
        }
        String phone= homeService.decryptData(request.getString("encryptedData"),request.getString("iv"),sessionKey).getString("phoneNumber");
        User user=userService.findUserById(request.getInteger("id"));
        if( user.getPhone() ==null || user.getPhone().equals(""))
        {
            user.setPhone(phone);
            userService.update(user);
        }
        res.put("code",1);
        res.put("msg","phone");
        res.put("data",phone);
        System.out.println(res.toJSONString());
        return res;
    }

    /**
     *  手机号/短信验证
     * @param request
     * @return
     */
    @RequestMapping("/message")
    public JSONObject messageAC(@RequestBody JSONObject request, HttpServletRequest http){
        JSONObject res =new JSONObject();
        System.out.println(request.toJSONString());
        HttpSession session =http.getSession();
        User user=userService.findUserByPhone(request.getString("phone"));
        String code;
        if(user==null)
        {
            code= HomeService.verifyCode();
            session.setAttribute("code",code);
            session.setMaxInactiveInterval(1200);
            TokenService.sessionHashMap.put(session.getId(),session);
            JSONObject respone=homeService.senSms(request.getString("phone"),code);
            System.out.println(respone.toJSONString());
            res.put("code",1);
            res.put("msg",respone.getString("Message"));
            res.put("data",session.getId());
            return res;
        }
        res.put("code",0);
        res.put("msg","已注册");
        return res;
    }

    /** 注册
     * @param request
     * @return
     */
    @RequestMapping("/register")
    public JSONObject register(@RequestBody JSONObject request,HttpServletRequest http) {
        System.out.println(request.toJSONString());
        JSONObject res = new JSONObject();
        if(userService.findUserByPhone(request.getString("phone"))!=null)
        {
           res.put("code",1);
           res.put("msg","已注册");
           res.put("data","");
            return res;
        }
        String url = "https://api.weixin.qq.com/sns/jscode2session" + "?appid=" + appId + "&secret=" + appSecret + "&js_code=" + request.getString("code") + "&grant_type="
                + grantType;
        String sessionId = request.getString("codeId");
        try {
            HttpSession session = TokenService.sessionHashMap.get(sessionId);
        if (!request.getString("code").equals(session.getAttribute("code").toString())) {
            res.put("code", 0);
            res.put("msg", "验证码错误");
            return res;
        }
        }catch (Exception e)
        {
            res.put("code", 0);
            res.put("msg", "验证码失效");
            return res;
        }
        String data = HttpUtil.get(url);
        System.out.println("data"+data);
        JSONObject params=JSONObject.parseObject(data);
        String openId=params.getString("openid");
        Integer upline=request.getInteger("v_id");
        res.put("code",1);
        res.put("msg","register");
        System.out.println(openId);
        User user=new User();
        user.setName(request.getString("nickName"));
        user.setNickName(request.getString("nickName"));
        user.setPhone(request.getString("phone"));
        user.setPassword(request.getString("password"));
        user.setCreateTime(new Date());
        user.setOpenId(openId);
        user.setPortraitUrl(request.getString("avatarUrl"));
        user.setGender(request.getInteger("gender"));
        if(upline !=null)
        {
            user.setUpline(upline);
            Integer upupline =userService.findUserById(upline).getUpline();
            if(upupline!=null)
            {
                user.setUpupline(upupline);
            }
        }
        userService.Add(user);
        if (user.getProgramCode() == null || user.getProgramCode() =="")
        {
            System.out.println("programCode");
            String accessToken=TokenService.getAccessToken();
            System.out.println(accessToken);
            String filename= QRcodeUtil.getminiqrQr(user.getId().toString(),accessToken,uploadFolder);
            if(filename !=null && filename !="")
            {
                filename = http.getScheme() + "://" + http.getServerName() + ":" + http.getServerPort() + "/" +filename;
            }
            user.setProgramCode(filename);
            userService.update(user);
        }
        ServicePersonnel personnel =new ServicePersonnel(user);
        personnelService.addPersonnel(personnel);
        Address address=new Address();
        address.setProvince(request.getString("province"));
        address.setCounty(request.getString("district"));
        address.setCity(request.getString("city"));
        address.setLatitude(request.getDouble("latitude"));
        address.setLongtitude(request.getDouble("longitude"));
        address.setUserId(user.getId());
        addressService.add(address);
        res.put("code",1);
        res.put("msg","register");
        res.put("data",1);
        System.out.println(res);
        return res;
    }
    @RequestMapping("/loginByPhone")
    public JSONObject loginByName(@RequestBody JSONObject request) {
        JSONObject res = new JSONObject();
        String password=request.getString("password");
        String phone= request.getString("phone");
        User  user=userService.findUserByPhone(phone);
        if (user!=null)
        {
            if(user.getPassword().equals(password))
            {
                res.put("code",1);
                res.put("msg","success");
                res.put("data",user);
                return res;
            }
        }
        res.put("code",0);
        res.put("msg","密码错误或用户名错误");
        return res;
    }






}
