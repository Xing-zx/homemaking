package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Lecture;
import com.zeropoint.homemaking.domain.LectureOrders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface LectureOrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LectureOrders record);

    LectureOrders selectByPrimaryKey(Integer id);

    List<LectureOrders> selectAll();

    int updateByPrimaryKey(LectureOrders record);

    List<LectureOrders> findLectureOrderByUserId(Integer userId);

    LectureOrders findByUserIdAndId(Integer lectureId, Integer userId);

    LectureOrders findByOrderNumber(String orderNumber);
}