package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.HelpCenter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface HelpCenterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HelpCenter record);

    HelpCenter selectByPrimaryKey(Integer id);

    List<HelpCenter> selectAll();

    int updateByPrimaryKey(HelpCenter record);

    HelpCenter selectByName(String name);
}