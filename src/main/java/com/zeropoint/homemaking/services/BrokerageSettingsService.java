package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.BrokerageSetting;

import java.util.List;

public interface BrokerageSettingsService {

    /**
     *  条件查询
     * @param condition  注册时间,姓名,角色
     * @return the admin list
     */
    List<BrokerageSetting> selectByCondition(Integer page, Integer rows);

    int count();

    int delete(Integer[] ids);

    BrokerageSetting selectKey(Integer id);

    int update(Integer id, Integer status);

    int insert(BrokerageSetting record);
}
