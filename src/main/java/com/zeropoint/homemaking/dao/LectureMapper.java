package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Lecture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LectureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Lecture record);

    Lecture selectByPrimaryKey(Integer id);

    List<Lecture> selectAll();

    int updateByPrimaryKey(Lecture record);
}