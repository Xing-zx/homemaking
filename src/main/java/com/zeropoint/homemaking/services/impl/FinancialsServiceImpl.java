package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.FinancialMapper;
import com.zeropoint.homemaking.domain.Financial;
import com.zeropoint.homemaking.services.FinancialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialsServiceImpl implements FinancialsService {

    @Autowired
    private FinancialMapper financialMapper;

    @Override
    public List<Financial> selectByCondition(Integer page,Integer rows,String name,Integer orderType,String startTime,String endTime) {
        return financialMapper.selectByCondition(page, rows, name, orderType, startTime, endTime);
    }

    @Override
    public int count(String name, Integer orderType, String startTime, String endTime) {
        return financialMapper.count(name, orderType, startTime, endTime);
    }

    @Override
    public int delete(Integer[] ids) {
        return financialMapper.delete(ids);
    }

    @Override
    public Financial selectKey(Integer id) {
        return financialMapper.selectKey(id);
    }
}
