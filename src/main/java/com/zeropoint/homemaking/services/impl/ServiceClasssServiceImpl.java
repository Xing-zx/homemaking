package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.ServiceClassificationMapper;
import com.zeropoint.homemaking.domain.ServiceClassification;
import com.zeropoint.homemaking.services.ServiceClassificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClasssServiceImpl implements ServiceClassificationsService {

    @Autowired
    private ServiceClassificationMapper scm;

    @Override
    public List<ServiceClassification> selectAll() {
        return scm.selectAll();
    }

    @Override
    public int updateStatus(int id, int status) {
        return scm.updateStatus1(id,status);
    }

    @Override
    public void delete(Integer[] ids) {
        scm.delete1(ids);
    }

    @Override
    public List<ServiceClassification> selectPage(Integer page, Integer rows) {
        return scm.selectPage1(page, rows);
    }

    @Override
    public int count() {
        return scm.count1();
    }

    @Override
    public int insert(ServiceClassification record) {
        return scm.insert(record);
    }

    @Override
    public ServiceClassification selectByPrimaryKey(Integer id) {
        return scm.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(ServiceClassification record) {
        return scm.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey1(Integer id) {
        return scm.deleteByPrimaryKey1(id);
    }

    @Override
    public int insert1(ServiceClassification record) {
        return scm.insert1(record);
    }

    @Override
    public List<ServiceClassification> selectAll1() {
        return scm.selectAll1();
    }

    @Override
    public List<ServiceClassification> selectPage1(Integer page, Integer rows) {
        return scm.selectPage1(page, rows);
    }

    @Override
    public int count1() {
        return scm.count1();
    }

    @Override
    public ServiceClassification selectByPrimaryKey1(Integer id) {
        return scm.selectByPrimaryKey1(id);
    }

    @Override
    public int updateByPrimaryKey1(ServiceClassification record) {
        return scm.updateByPrimaryKey1(record);
    }

    @Override
    public int updateStatus1(int id, int status) {
        return scm.updateStatus1(id, status);
    }

    @Override
    public void delete1(Integer[] ids) {
        scm.delete1(ids);
    }


}
