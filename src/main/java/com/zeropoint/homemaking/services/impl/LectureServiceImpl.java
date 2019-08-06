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
    private LectureMapper lectureMapper;
    @Autowired
    private LectureOrdersMapper lectureOrdersMapper;
    @Override
    public List<Lecture> getList() {
        return lectureMapper.selectAll();
    }

    @Override
    public Lecture findLectureById(Integer id) {
        return lectureMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete1(Integer[] ids) {
        return lectureMapper.delete1(ids);
    }

    @Override
    public int insert1(Lecture record) {
        return lectureMapper.insert1(record);
    }

    @Override
    public Lecture selectByPrimaryKey1(Integer id) {
        return lectureMapper.selectByPrimaryKey1(id);
    }

    @Override
    public List<Lecture> selectAll1() {
        return lectureMapper.selectAll1();
    }

    @Override
    public int updateByPrimaryKey1(Lecture record) {
        return lectureMapper.updateByPrimaryKey1(record);
    }

    @Override
    public List<Lecture> selectByCondition1(Integer page, Integer rows, String name, Integer status, String endTime, String startTime) {
        return lectureMapper.selectByCondition1(page, rows, name, status, endTime, startTime);
    }

    @Override
    public int count1(String name, Integer status, String endTime, String startTime) {
        return lectureMapper.count1(name, status, endTime, startTime);
    }

    @Override
    public int updateStatus1(Integer id, Integer status) {
        return lectureMapper.updateStatus1(id, status);
    }


}
