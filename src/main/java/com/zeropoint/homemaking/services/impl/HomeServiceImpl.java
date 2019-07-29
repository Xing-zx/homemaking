package com.zeropoint.homemaking.services.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.zeropoint.homemaking.dao.BannersMapper;
import com.zeropoint.homemaking.dao.ServiceClassificationMapper;
import com.zeropoint.homemaking.domain.Banners;
import com.zeropoint.homemaking.domain.ServiceClassification;
import com.zeropoint.homemaking.services.HomeService;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private ServiceClassificationMapper menu;
    @Autowired
    private BannersMapper bannersMapper;
    @Override
    public List<ServiceClassification> getMenu() {
        return menu.selectAll();
    }
    @Override
    public List<Banners> getSwiper() {
        return bannersMapper.selectAll();
    }

    @Override
    public JSONObject decryptData(String encryptedData, String iv,String sessionKey) {
        byte[] dataByte = Base64.decodeBase64(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decodeBase64(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decodeBase64(iv);
        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public JSONObject senSms(String phoneNumber,String code) {
        DefaultProfile profile = DefaultProfile.getProfile("default", "LTAI6gvezLPo7XXZ", "81XXNXcWsHrA25KGw4Ai35lc9GcYjF");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        JSONObject params= new JSONObject();
        params.put("code",code);
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName","零点科技");
        request.putQueryParameter("TemplateCode", "SMS_154594981");
        request.putQueryParameter("TemplateParam", params.toJSONString());
        CommonResponse response;
        try {
             response = client.getCommonResponse(request);
            return JSONObject.parseObject(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }





}
