package com.zeropoint.homemaking.utils;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 */
public class ConvertUtil {
    public static String addressStrConvert(String oldStr)
    {
        String res=oldStr;
        res= res.replaceAll("省","省/");
        res=res.replaceAll("市","市/");
        res=res.replaceAll("区","区/");
        if(res.charAt(res.length()-1)== '/')
        {
            res =res.substring(0,res.length()-1);
        }
        System.out.println(res);
        return res;
    }
    public static String requirementConvert(String[] oldStrs){
        StringBuilder stringBuilder=new StringBuilder();
        for(String str:oldStrs)
        {
            stringBuilder.append(str+",");
        }
        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }
    public  static Date workdateConvert(String workDate,String workTime){
        String dateStr=workDate+" "+workTime;
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date date=sDateFormat.parse(dateStr);
            System.out.println(date);
            return date;
        } catch(ParseException px) {
            px.printStackTrace();
        }
        return null;
    }
    public static   List<String> getImgStr(String htmlStr) {
        List<String> pics = new ArrayList<String>();
        String img = "";
        Pattern p_image;
        Matcher m_image;
        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
        m_image = p_image.matcher(htmlStr);
        while (m_image.find()) {
            // 得到<img />数据
            img = m_image.group();
            // 匹配<img>中的src数据
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find()) {
                pics.add(m.group(1));
            }
        }
        return pics;
    }
}
