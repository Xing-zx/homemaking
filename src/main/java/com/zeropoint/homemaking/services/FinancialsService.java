package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.Financial;

import java.util.List;

public interface FinancialsService {

    /**
     *  条件查询
     * @param condition  注册时间,姓名,角色
     * @return the admin list
     */
    List<Financial> selectByCondition(Integer page, Integer rows, String name, Integer orderType, String startTime, String endTime);

    int count(String name, Integer orderType, String startTime, String endTime);

    int delete(Integer[] ids);

    Financial selectKey(Integer id);
}
