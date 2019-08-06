package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.HelpCenter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface HelpCenterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HelpCenter record);

    HelpCenter selectByPrimaryKey(Integer id);

    List<HelpCenter> selectAll();

    int updateByPrimaryKey(HelpCenter record);

    HelpCenter selectByName(String name);

    int update1(HelpCenter helpCenter);

    HelpCenter select1(@Param("id")Integer id);

    int update2(HelpCenter helpCenter);

    HelpCenter select2(@Param("id")Integer id);

    int update3(HelpCenter helpCenter);

    HelpCenter select3(@Param("id")Integer id);
}