package com.zeropoint.homemaking.DAO;

import com.zeropoint.homemaking.Entitys.Lecture;
import java.util.List;

public interface LectureMapper {
    int insert(Lecture record);

    List<Lecture> selectAll();
}