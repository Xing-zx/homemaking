package com.zeropoint.homemaking.dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.zeropoint.homemaking.domain.Order;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.vo.PersonnelOrder;
import com.zeropoint.homemaking.vo.UserOder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    Order selectByPrimaryKey(Integer id);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);

    List<Order> selectByPersonnelId(Integer personnelId);

    List<UserOder> selectByUserId(Integer userId);

    List<PersonnelOrder> selectPersonnelOrderByPersonnelId(Integer personnelId);

    Order selectByOrderNumber(String orderNumber);

    int insert1(Order record);

    List<Order> selectAll1(@Param("page")Integer page, @Param("rows")Integer rows, @Param("type")Integer type,
                           @Param("name")String name, @Param("endTime")String endTime, @Param("startTime")String startTime);

    int count1(@Param("type")Integer type,@Param("name")String name,@Param("endTime")String endTime,@Param("startTime")String startTime);

    int delete1(@Param("ids")Integer[] ids);

    Order selectKey1(@Param("id")Integer id);

    List<ServicePersonnel> serviceSelect1(@Param("page")Integer page, @Param("rows")Integer rows, @Param("ids")Integer[] ids);

    int counts1(@Param("ids")Integer[] ids);

    List<Order> selectOrder1(@Param("page")Integer page, @Param("rows")Integer rows, @Param("type")Integer type,
                             @Param("name")String name,@Param("status")Integer status, @Param("endTime")String endTime, @Param("startTime")String startTime);

    int countOrder1(@Param("type")Integer type,@Param("status")Integer status,@Param("name")String name,@Param("endTime")String endTime,@Param("startTime")String startTime);

    ServicePersonnel personnelView1(@Param("id")Integer id);
}