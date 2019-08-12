package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.BrokerageSetting;
import com.zeropoint.homemaking.domain.Withdraw;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WithdrawsService {

    List<Withdraw> selectPage(Integer page,Integer rows, String name,String endTime,String startTime);

    int count(String name,String endTime,String startTime);

    int update(Integer id, Integer status);

    int insert1(Withdraw record);

    List<Withdraw> selectAll1();

    List<Withdraw> selectPage1(Integer page,Integer rows, String name,String endTime,String startTime);

    int count1(String name,String endTime,String startTime);

    int update1(Integer id,Integer status);

    BrokerageSetting selectfee();

    int update2(Integer id,Double fee,Double finalMoney);

    int delete1(Integer[] ids);
}