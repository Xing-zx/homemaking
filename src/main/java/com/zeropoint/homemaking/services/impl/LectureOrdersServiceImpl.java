package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.LectureOrdersMapper;
import com.zeropoint.homemaking.domain.LectureOrders;
import com.zeropoint.homemaking.services.LectureOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureOrdersServiceImpl implements LectureOrdersService {

    @Autowired
    private LectureOrdersMapper lectureOrdersMapper;

    @Override
    public int insert(LectureOrders record) {
        return lectureOrdersMapper.insert(record);
    }

    @Override
    public List<LectureOrders> selectAll() {
        return lectureOrdersMapper.selectAll();
    }

    @Override
    public List<LectureOrders> selectByCondition(Integer page, Integer rows, String name, Integer status, String endTime, String startTime) {
        return lectureOrdersMapper.selectByCondition1(page, rows, name, status, endTime, startTime);
    }

    @Override
    public int count(String name, Integer status, String endTime, String startTime) {
        return lectureOrdersMapper.count1(name, status, endTime, startTime);
    }


    @Override
    public int delete(Integer[] ids) {
        return lectureOrdersMapper.delete1(ids);
    }

    @Override
    public LectureOrders selectKey(Integer id) {
        return lectureOrdersMapper.selectKey1(id);
    }

    @Override
    public int insert1(LectureOrders record) {
        return lectureOrdersMapper.insert1(record);
    }

    @Override
    public List<LectureOrders> selectAll1() {
        return lectureOrdersMapper.selectAll1();
    }

    @Override
    public List<LectureOrders> selectByCondition1(Integer page, Integer rows, String name, Integer status, String endTime, String startTime) {
        return lectureOrdersMapper.selectByCondition1(page, rows, name, status, endTime, startTime);
    }

    @Override
    public int count1(String name, Integer status, String endTime, String startTime) {
        return lectureOrdersMapper.count1(name, status, endTime, startTime);
    }

    @Override
    public int delete1(Integer[] ids) {
        return lectureOrdersMapper.delete1(ids);
    }

    @Override
    public LectureOrders selectKey1(Integer id) {
        return lectureOrdersMapper.selectKey1(id);
    }


}
