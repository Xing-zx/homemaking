package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Withdraw;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface WithdrawMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Withdraw record);

    Withdraw selectByPrimaryKey(Integer id);

    List<Withdraw> selectAll();

    int updateByPrimaryKey(Withdraw record);

    List<Withdraw> selectByPersonnelAndDate(Integer personnelId,String date);
}