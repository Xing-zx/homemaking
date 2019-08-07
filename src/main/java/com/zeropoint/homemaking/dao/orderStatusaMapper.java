package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.OrderStatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface orderStatusaMapper {
    int insert(OrderStatus record);

    List<OrderStatus> selectAll();
}