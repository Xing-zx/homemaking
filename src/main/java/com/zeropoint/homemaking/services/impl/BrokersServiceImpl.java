package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.BrokerMapper;
import com.zeropoint.homemaking.domain.Broker;
import com.zeropoint.homemaking.services.BrokersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrokersServiceImpl implements BrokersService {

    @Autowired
    private BrokerMapper brokerMapper;

    @Override
    public int insert(Broker record) {
        return brokerMapper.insert(record);
    }

    @Override
    public List<Broker> selectByCondition(Integer page,Integer rows,String name,String endTime,String startTime){
        return brokerMapper.selectByCondition(page,rows,name,endTime,startTime);
    }

    @Override
    public int count(String name,String endTime,String startTime){
        return brokerMapper.count(name,endTime,startTime);
    }

    @Override
    public void delete(Integer[] ids) {
         brokerMapper.delete(ids);
    }

    @Override
    public int updateStatus(Integer id, Integer status) {
        return brokerMapper.updateStatus(id,status);
    }

    @Override
    public Broker SelectKey(Integer id) {
        return brokerMapper.SelectKey(id);
    }

    @Override
    public int updateAll(Broker broker) {
        return brokerMapper.updateAll(broker);
    }
}
