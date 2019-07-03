package com.zeropoint.homemaking.DAO;

import com.zeropoint.homemaking.Entitys.Order;
import java.util.List;

public interface OrderMapper {
    int insert(Order record);

    List<Order> selectAll();
}