package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.UserRequirement;

import java.util.List;

public interface UserRequirementsService {

    int deleteByPrimaryKey(Integer id);

    int insert(UserRequirement record);

    UserRequirement selectByPrimaryKey(Integer id);

    List<UserRequirement> selectAll();

    int updateByPrimaryKey(UserRequirement record);
}
