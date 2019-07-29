package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.Lecture;

import java.util.List;

public interface LectureService {

    List<Lecture> getList();
    Lecture findLectureById(Integer id);


}
