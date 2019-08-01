package com.zeropoint.homemaking.services;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.config.WechatConfig;
import com.zeropoint.homemaking.utils.PayUtil;
import com.zeropoint.homemaking.vo.PayOrder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Administrator
 */
@Service
public class PayService {

    public JSONObject wxPay(String spbill_create_ip, String openId, PayOrder order)throws Exception{
        //返回给小程序端需要的参数
        JSONObject res = new JSONObject();

            //生成的随机字符串
            String nonce_str = getRandomStringByLength(32);
            //商品名称
            String body = order.getGoodName();
            int price = order.getAmount().intValue();
            //组装参数，用户生成统一下单接口的签名
            Map<String, String> packageParams = new HashMap<>();
            packageParams.put("appid", WechatConfig.appid);
            packageParams.put("mch_id", WechatConfig.mch_id);
            packageParams.put("nonce_str", nonce_str);
            packageParams.put("body", body);
            //商户订单号,自己的订单ID
            packageParams.put("out_trade_no", order.getOrderNumber());
            //支付金额，这边需要转成字符串类型，否则后面的签名会失败
            packageParams.put("total_fee", price + "");
            packageParams.put("spbill_create_ip", spbill_create_ip);
            //支付方式
            packageParams.put("notify_url", WechatConfig.NOTIFY_URL);
            packageParams.put("trade_type", WechatConfig.TRADE_TYPE);
            //用户的openID，自己获取
            packageParams.put("openid", openId + "");
            // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
            String prestr = PayUtil.createLinkString(packageParams);
            //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
            String mysign = PayUtil.sign(prestr, WechatConfig.key, "utf-8").toUpperCase();
            System.out.println(mysign);
            //拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
            String xml = "<xml>" + "<appid>" + WechatConfig.appid + "</appid>"
                    + "<body><![CDATA[" + body + "]]></body>"
                    + "<mch_id>" + WechatConfig.mch_id + "</mch_id>"
                    + "<nonce_str>" + nonce_str + "</nonce_str>"
                    + "<notify_url>" + WechatConfig.NOTIFY_URL + "</notify_url>"
                    + "<openid>" + openId + "</openid>"
                    + "<out_trade_no>" + order.getOrderNumber() + "</out_trade_no>"
                    + "<spbill_create_ip>" + spbill_create_ip + "</spbill_create_ip>"
                    + "<total_fee>" + price + "</total_fee>"
                    + "<trade_type>" + WechatConfig.TRADE_TYPE + "</trade_type>"
                    + "<sign>" + mysign + "</sign>"
                    + "</xml>";
            System.out.println(xml);
            //调用统一下单接口，并接受返回的结果
            String result = PayUtil.httpRequest(WechatConfig.pay_url, "POST", xml);
            if (result == null || result =="")
            {
                System.out.println("无结果");
                return null;
            }
            // 将解析结果存储在HashMap中
            Map map = PayUtil.doXMLParse(result);
            //返回状态码
            String return_code = (String) map.get("return_code");
            String result_code = (String) map.get("result_code");
            String return_msg = (String) map.get("return_msg");
            //返回状态码
            String err_code = (String) map.get("err_code");
            //返回状态码
            String err_code_des = (String) map.get("err_code_des");
            //返回状态码
            res.put("return",return_code);
            res.put("result",result_code);
            res.put("return_msg",return_msg);
            if (return_code.equals("SUCCESS") || return_code.equals(result_code)) {
                String prepay_id = (String) map.get("prepay_id");
                //返回的预付单信息
                res.put("nonceStr", nonce_str);
                res.put("package", "prepay_id=" + prepay_id);
                Long timeStamp = System.currentTimeMillis() / 1000;
                res.put("timeStamp", timeStamp + "");
                res.put("signType","MD5");
                //这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误
                //拼接签名需要的参数
                String stringSignTemp = "appId=" + WechatConfig.appid + "&nonceStr=" + nonce_str + "&package=prepay_id=" + prepay_id + "&signType=MD5&timeStamp=" + timeStamp;
                //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
                String paySign = PayUtil.sign(stringSignTemp, WechatConfig.key, "utf-8").toUpperCase();
                System.out.println(stringSignTemp);
                res.put("paySign", paySign);
                res.put("orderNumber",order.getOrderNumber());
            } else {
                return res;
            }
            res.put("appid", WechatConfig.appid);

        return res;
    }

    /**
     * 获取随机字符串
     */
    private String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}

