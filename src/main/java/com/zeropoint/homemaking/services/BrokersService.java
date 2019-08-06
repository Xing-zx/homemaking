package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.Broker;

import java.util.List;

public interface BrokersService {

    int insert(Broker record);

    List<Broker> selectByCondition(Integer page, Integer rows, String name, String endTime, String startTime);

    int count(String name, String endTime, String startTime);

    void delete(Integer[] ids);

    int updateStatus(Integer id, Integer status);

    Broker SelectKey(Integer id);

    int updateAll(Broker broker);
}
