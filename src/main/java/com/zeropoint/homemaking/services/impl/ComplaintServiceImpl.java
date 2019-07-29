package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.ComplaintMapper;
import com.zeropoint.homemaking.domain.Complaint;
import com.zeropoint.homemaking.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    ComplaintMapper complaintMapper;
    @Override
    public int add(Complaint complaint) {
        return complaintMapper.insert(complaint);
    }
}
