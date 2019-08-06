package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentsService {

    int insert1(Comment record);

    List<Comment> selectAll1();

    List<Comment> selectPage1(Integer page,Integer rows,String name,String endTime,String startTime);

    int count1(String name,String endTime,String startTime);

    int delete1(Integer[] ids);
}
