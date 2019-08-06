package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.UserRequirementMapper;
import com.zeropoint.homemaking.domain.UserRequirement;
import com.zeropoint.homemaking.services.UserRequirementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRequirementsServiceImpl implements UserRequirementsService {

    @Autowired
    private UserRequirementMapper userRequirementMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userRequirementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserRequirement record) {
        return userRequirementMapper.insert(record);
    }

    @Override
    public UserRequirement selectByPrimaryKey(Integer id) {
        return userRequirementMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserRequirement> selectAll() {
        return userRequirementMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(UserRequirement record) {
        return userRequirementMapper.updateByPrimaryKey(record);
    }
}
