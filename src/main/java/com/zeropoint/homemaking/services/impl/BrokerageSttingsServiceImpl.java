package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.BrokerageSettingMapper;
import com.zeropoint.homemaking.domain.BrokerageSetting;
import com.zeropoint.homemaking.services.BrokerageSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrokerageSttingsServiceImpl implements BrokerageSettingsService {

    @Autowired
    private BrokerageSettingMapper brokerage;

    @Override
    public List<BrokerageSetting> selectByCondition(Integer page,Integer rows ){
        return brokerage.selectByCondition(page,rows);
    }

    @Override
    public int count(){
        return brokerage.count();
    }

    @Override
    public int delete(Integer[] ids) {
        return brokerage.delete(ids);
    }

    @Override
    public BrokerageSetting selectKey(Integer id) {
        return brokerage.selectKey(id);
    }


    @Override
    public int update(Integer id, Integer status) {
        return brokerage.update(id,status);
    }

    @Override
    public int insert(BrokerageSetting record) {
        return brokerage.insert(record);
    }
}
