package com.zeropoint.homemaking.utils;

import java.security.MessageDigest;

public class MD5Util {
    /**
     * @Title: encodeByMD5
     * @Description: 对字符串进行MD5编码
     * @author yihj
     * @param @param originString
     * @param @return    参数
     * @return String    返回类型
     * @throws
     */
    public static String MD5(String originString){
        if (originString!=null) {
            try {
                //创建具有指定算法名称的信息摘要
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
                byte[] results = md5.digest(originString.getBytes());
                //将得到的字节数组变成字符串返回
                String result = byteArrayToHexString(results);
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static String byteArrayToHexString(byte[] bArr) {
        StringBuffer sb = new StringBuffer(bArr.length);
        String sTmp;

        for (int i = 0; i < bArr.length; i++) {
            sTmp = Integer.toHexString(0xFF & bArr[i]);
            if (sTmp.length() < 2)
            {
                sb.append(0);
            }
            sb.append(sTmp.toUpperCase());
        }

        return sb.toString();
    }

}
