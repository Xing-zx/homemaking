package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Withdraw;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface WithdrawMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Withdraw record);

    Withdraw selectByPrimaryKey(Integer id);

    List<Withdraw> selectAll();

    int updateByPrimaryKey(Withdraw record);

    List<Withdraw> selectByPersonnelAndDate(Integer personnelId,String date);

    int insert1(Withdraw record);

    List<Withdraw> selectAll1();

    List<Withdraw> selectPage1(@Param("page")Integer page, @Param("rows")Integer rows, String name,
                               @Param("endTime")String endTime, @Param("startTime")String startTime);

    int count1(String name,@Param("endTime")String endTime,@Param("startTime")String startTime);

    int update1(Integer id,Integer status);
}