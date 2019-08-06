package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.Broker;
import com.zeropoint.homemaking.domain.Stores;

import java.util.List;

public interface StoresdService {

    int insert(Stores record);
    /**
     *  条件查询
     * @param condition  注册时间,姓名,角色
     * @return the admin list
     */
    List<Stores> selectByCondition(Integer page, Integer rows, String name, String endTime, String startTime);

    int count(String name, String endTime, String startTime);

    int delete(Integer[] ids);

    Stores SelectAll(Integer storesId);

    int updateAll(Stores stores);

    int updateStatus(Integer storesId, Integer status);

    List<Broker> selectBroker();
}
