package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.LectureMapper;
import com.zeropoint.homemaking.dao.LectureOrdersMapper;
import com.zeropoint.homemaking.domain.Lecture;
import com.zeropoint.homemaking.services.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class LectureServiceImpl implements LectureService {
    @Autowired
    LectureMapper lectureMapper;
    @Autowired
    LectureOrdersMapper lectureOrdersMapper;
    @Override
    public List<Lecture> getList() {
        return lectureMapper.selectAll();
    }

    @Override
    public Lecture findLectureById(Integer id) {
        return lectureMapper.selectByPrimaryKey(id);
    }


}
