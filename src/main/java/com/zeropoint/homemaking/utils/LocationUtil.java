package com.zeropoint.homemaking.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class LocationUtil {

    /**
     *  城市
     */
    private String city;

    /**
     * 省
     */
    private String province;

    /**
     * 地球半径
     */
    private static final double EARTH_RADIUS = 6378.137;



    /**
     * @param latitude   纬度
     * @param longtitude 经度
     * @return  省，市
     */
    Map<String,String> locate(String latitude,String longtitude)
    {
        Map<String,String> res = new HashMap<>(2);

        return res;
    }

    /** 弧度转换
     * @param d  度数
     * @return 弧度
     */
    private static double rad(double d)
    {
        return d * Math.PI / 180.0;
    }

    /**
     * @param lat1 纬度1
     * @param lng1 经度1
     * @param lat2 纬度2
     * @param lng2 经度2
     * @return distance
     */
    public static double getDistance(double lat1,double lng1,double lat2,double lng2)
    {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);

        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
                Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;

    }

}
