package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Lecture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LectureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Lecture record);

    Lecture selectByPrimaryKey(Integer id);

    List<Lecture> selectAll();

    int updateByPrimaryKey(Lecture record);

    int delete1(@Param("ids")Integer[] ids);

    int insert1(Lecture record);

    /*查询单个*/
    Lecture selectByPrimaryKey1(Integer id);

    List<Lecture> selectAll1();

    int updateByPrimaryKey1(Lecture record);

    /**
     *  条件查询
     * @param condition  注册时间,姓名,角色
     * @return the admin list
     */
    List<Lecture> selectByCondition1(@Param("page")Integer page,@Param("rows")Integer rows,@Param("name")String name,@Param("status")Integer status,
                                     @Param("endTime") String endTime,@Param("startTime") String startTime);

    int count1(@Param("name")String name,@Param("status")Integer status,@Param("endTime")String endTime,@Param("startTime")String startTime);

    int updateStatus1(@Param("id")Integer id, @Param("status")Integer status);
}