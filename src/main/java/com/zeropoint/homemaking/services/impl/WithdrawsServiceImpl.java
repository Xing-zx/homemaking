package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.WithdrawMapper;
import com.zeropoint.homemaking.domain.BrokerageSetting;
import com.zeropoint.homemaking.domain.Withdraw;
import com.zeropoint.homemaking.services.WithdrawsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WithdrawsServiceImpl implements WithdrawsService {

    @Autowired
    private WithdrawMapper withdrawMapper;


    @Override
    public List<Withdraw> selectPage(Integer page, Integer rows, String name, String endTime, String startTime) {
        return withdrawMapper.selectPage1(page, rows, name, endTime, startTime);
    }

    @Override
    public int count(String name, String endTime, String startTime) {
        return withdrawMapper.count1(name, endTime, startTime);
    }

    @Override
    public int update(Integer id, Integer status) {
        return withdrawMapper.update1(id, status);
    }

    @Override
    public int insert1(Withdraw record) {
        return withdrawMapper.insert1(record);
    }

    @Override
    public List<Withdraw> selectAll1() {
        return withdrawMapper.selectAll1();
    }

    @Override
    public List<Withdraw> selectPage1(Integer page, Integer rows, String name, String endTime, String startTime) {
        return withdrawMapper.selectPage1(page, rows, name, endTime, startTime);
    }

    @Override
    public int count1(String name, String endTime, String startTime) {
        return withdrawMapper.count1(name, endTime, startTime);
    }

    @Override
    public int update1(Integer id, Integer status) {
        return withdrawMapper.update1(id, status);
    }

    @Override
    public BrokerageSetting selectfee() {
        return withdrawMapper.selectfee();
    }

    @Override
    public int update2(Integer id, Double fee, Double finalMoney) {
        return withdrawMapper.update2(id, fee, finalMoney);
    }

    @Override
    public int delete1(Integer[] ids) {
        return withdrawMapper.delete1(ids);
    }
}
