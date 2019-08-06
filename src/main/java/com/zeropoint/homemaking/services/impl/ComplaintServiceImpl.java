package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.ComplaintMapper;
import com.zeropoint.homemaking.domain.Complaint;
import com.zeropoint.homemaking.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintMapper complaintMapper;
    @Override
    public int add(Complaint complaint) {
        return complaintMapper.insert(complaint);
    }

    @Override
    public int insert1(Complaint record) {
        return complaintMapper.insert1(record);
    }

    @Override
    public List<Complaint> selectAll1() {
        return complaintMapper.selectAll1();
    }

    @Override
    public List<Complaint> selectPage1(Integer page, Integer rows) {
        return complaintMapper.selectPage1(page, rows);
    }

    @Override
    public int delete1(Integer[] ids) {
        return complaintMapper.delete1(ids);
    }

    @Override
    public int count1() {
        return complaintMapper.count1();
    }
}
