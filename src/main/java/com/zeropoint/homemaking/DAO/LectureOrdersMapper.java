package com.zeropoint.homemaking.DAO;

import com.zeropoint.homemaking.Entitys.LectureOrders;
import java.util.List;

public interface LectureOrdersMapper {
    int insert(LectureOrders record);

    List<LectureOrders> selectAll();
}