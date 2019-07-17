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

    JSONObject decryptData(String encryptedData, String iv, String sessionKey);

    /**
     * 发送信息
     *
     * @param
     * @return
     */
    JSONObject senSms(String phoneNumber, String code);

    static String verifyCode() {
        String str = "";
        char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            char num = ch[random.nextInt(ch.length)];
            str += num;
        }
        return str;
    }
}
