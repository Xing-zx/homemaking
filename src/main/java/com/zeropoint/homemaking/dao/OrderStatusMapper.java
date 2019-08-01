package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.OrderStatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface OrderStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderStatus record);

    OrderStatus selectByPrimaryKey(Integer id);

    List<OrderStatus> selectAll();

    int updateByPrimaryKey(OrderStatus record);

    List<OrderStatus> selectByOrderId(Integer orderId);
}