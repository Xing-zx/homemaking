package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    Comment selectByPrimaryKey(Integer id);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);

    int insert1(Comment record);

    List<Comment> selectAll1();

    List<Comment> selectPage1(@Param("page")Integer page, @Param("rows")Integer rows, @Param("name")String name,
                              @Param("endTime")String endTime, @Param("startTime")String startTime);

    int count1(@Param("name")String name,@Param("endTime")String endTime, @Param("startTime")String startTime);

    int delete1(@Param("ids")Integer[] ids);
}