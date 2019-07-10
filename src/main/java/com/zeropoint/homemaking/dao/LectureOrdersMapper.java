package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.LectureOrders;
import java.util.List;

public interface LectureOrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LectureOrders record);

    LectureOrders selectByPrimaryKey(Integer id);

    List<LectureOrders> selectAll();

    int updateByPrimaryKey(LectureOrders record);
}