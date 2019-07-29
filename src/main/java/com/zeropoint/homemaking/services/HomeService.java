package com.zeropoint.homemaking.services;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zeropoint.homemaking.domain.Banners;
import com.zeropoint.homemaking.domain.ServiceClassification;

import java.util.List;
import java.util.Random;

/**
 * @author Administrator
 */
public interface HomeService {

    /**
     * 菜单
     *
     * @return home Menu
     */
    List<ServiceClassification> getMenu();

    /**
     * 轮播图
     *
     * @return Swiper
     */
    List<Banners> getSwiper();

    /**
     *   获取用户手机号码
     * @param encryptedData 加密数据
     * @param iv 请求参数
     * @param sessionKey 会话密钥
     * @return
     */
    JSONObject decryptData(String encryptedData, String iv, String sessionKey);

    /**
     * 发送信息
     *
     * @param code  短信验证码
     * @param phoneNumber  电话号码
     * @return 接口返回值
     */
    JSONObject senSms(String phoneNumber, String code);


    /** 生成随机验证码
     * @return  验证码
     */
    static String verifyCode() {
        String str = "";
        char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random random = new Random();
        for (int i = 0; i <6; i++) {
            char num = ch[random.nextInt(ch.length)];
            str += num;
        }
        return str;
    }
    static String nonceStr(){
        String str = "";
        char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        Random random = new Random();
        for (int i = 0; i <12; i++) {
            char num = ch[random.nextInt(ch.length)];
            str += num;
        }
        return str;
    }
}
