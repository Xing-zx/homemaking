package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Lecture;
import java.util.List;

public interface LectureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Lecture record);

    Lecture selectByPrimaryKey(Integer id);

    List<Lecture> selectAll();

    int updateByPrimaryKey(Lecture record);
}