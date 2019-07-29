package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.UserRequirement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserRequirementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRequirement record);

    UserRequirement selectByPrimaryKey(Integer id);

    List<UserRequirement> selectAll();

    int updateByPrimaryKey(UserRequirement record);
}