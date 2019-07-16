package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.LectureMapper;
import com.zeropoint.homemaking.domain.Lecture;
import com.zeropoint.homemaking.services.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureServiceImpl implements LectureService {
    @Autowired
    LectureMapper lectureMapper;
    @Override
    public List<Lecture> getList() {
        return lectureMapper.selectAll();
    }
}
