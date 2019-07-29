package com.zeropoint.homemaking.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

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
}
