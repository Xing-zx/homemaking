package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Order;
import com.zeropoint.homemaking.vo.PersonnelOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    Order selectByPrimaryKey(Integer id);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);

    List<Order> selectByPersonnelId(Integer personnelId);

    List<Order> selectByUserId(Integer userId);

    List<PersonnelOrder> selectPersonnelOrderByPersonnelId(Integer personnelId);

    Order selectByOrderNumber(String orderNumber);
}