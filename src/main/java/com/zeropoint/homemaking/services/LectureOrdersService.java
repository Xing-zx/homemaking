package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.LectureOrders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LectureOrdersService {

    int insert(LectureOrders record);

    List<LectureOrders> selectAll();

    /**
     *  条件查询
     * @param condition  注册时间,姓名,角色
     * @return the admin list
     */
    List<LectureOrders> selectByCondition(Integer page, Integer rows, String name, Integer status, String endTime, String startTime);

    int count(String name, Integer status, String endTime, String startTime);

    int delete(Integer[] ids);

    LectureOrders selectKey(Integer id);

    int insert1(LectureOrders record);

    List<LectureOrders> selectAll1();

    /**
     *  条件查询
     * @param condition  注册时间,姓名,角色
     * @return the admin list
     */
    List<LectureOrders> selectByCondition1(Integer page,Integer rows,String name,Integer status,String endTime,String startTime);

    int count1(String name,Integer status,String endTime,String startTime);

    int delete1(Integer[] ids);

    LectureOrders selectKey1(Integer id);

    List<LectureOrders> selectByCondition2(Integer page,Integer rows,String name,Integer status,String endTime,String startTime);

    int count2(String name,Integer status,String endTime,String startTime);

    LectureOrders selectKey2(Integer id);
}
