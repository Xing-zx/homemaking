package com.zeropoint.homemaking.services;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zeropoint.homemaking.constant.Constant;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.domain.User;
import com.zeropoint.homemaking.utils.HttpUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;


/**
 * @author jinbin
 * @date 2018-07-08 21:04
 */
@Service("TokenService")
public class TokenService {
    public static HashMap<String, HttpSession> sessionHashMap=new HashMap<>();

    public  static String getToken(User user) {
        String token="";
        // 将 user id 保存到 token 里面
        token= JWT.create().withAudience(user.getId().toString())
                // 以 password 作为 token 的密钥
                .sign(Algorithm.HMAC256(user.getCreateTime().toString()));
        return token;
    }
    public static boolean authToken(String token,User user){
        if (token.equals(getToken(user)))
        {
            return true;
        }
        return false;
    }
    public  static String getAccessToken(){
        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
        String requsetURL = url.replaceAll("APPID", Constant.APP_ID).replaceAll("APPSECRET",Constant.APP_SECRET);
        System.out.println(requsetURL);
        String  data=HttpUtil.get(requsetURL);
        JSONObject res =JSONObject.parseObject(data);
        System.out.println(res);
        return  res.getString("access_token");
    }

}
