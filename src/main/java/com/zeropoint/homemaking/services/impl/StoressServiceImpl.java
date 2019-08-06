package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.StoresMapper;
import com.zeropoint.homemaking.domain.Broker;
import com.zeropoint.homemaking.domain.Stores;
import com.zeropoint.homemaking.services.StoresdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoressServiceImpl implements StoresdService {

    @Autowired
    private StoresMapper storesMapper;

    @Override
    public int insert(Stores record) {
        return storesMapper.insert(record);
    }

    @Override
    public List<Stores> selectByCondition(Integer page,Integer rows,String name,String endTime,String startTime) {
        return storesMapper.selectByCondition(page,rows,name,endTime,startTime);
    }

    public int count(String name,String endTime,String startTime){
        return storesMapper.count(name,endTime,startTime);
    }

    @Override
    public int delete(Integer[] ids) {
        return storesMapper.delete(ids);
    }

    @Override
    public Stores SelectAll(Integer storesId) {
        return storesMapper.SelectAll(storesId);
    }

    @Override
    public int updateAll(Stores stores) {
        return storesMapper.updateAll(stores);
    }

    @Override
    public int updateStatus(Integer storesId, Integer status) {
        return storesMapper.updateStatus(storesId,status);
    }

    @Override
    public List<Broker> selectBroker() {
        return storesMapper.selectBroker();
    }
}
