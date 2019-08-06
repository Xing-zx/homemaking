package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Lecture;
import com.zeropoint.homemaking.domain.LectureOrders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    int insert1(LectureOrders record);

    List<LectureOrders> selectAll1();

    /**
     *  条件查询
     * @param condition  注册时间,姓名,角色
     * @return the admin list
     */
    List<LectureOrders> selectByCondition1(@Param("page")Integer page, @Param("rows")Integer rows, @Param("name")String name, @Param("status")Integer status,
                                           @Param("endTime")String endTime, @Param("startTime")String startTime);

    int count1(@Param("name")String name,@Param("status")Integer status,@Param("endTime")String endTime,@Param("startTime")String startTime);

    int delete1(@Param("ids")Integer[] ids);

    LectureOrders selectKey1(@Param("id")Integer id);
}