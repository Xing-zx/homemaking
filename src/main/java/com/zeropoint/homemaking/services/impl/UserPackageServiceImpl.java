package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.UserPackageMapper;
import com.zeropoint.homemaking.domain.UserPackage;
import com.zeropoint.homemaking.services.UserPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPackageServiceImpl implements UserPackageService {

    @Autowired
    private UserPackageMapper userPackageMapper;


    @Override
    public List<UserPackage> selectByCondition1(Integer userId) {
        System.out.println(userId+"--------------111111111111111111111");
        return userPackageMapper.selectByCondition1(userId);
    }

    @Override
    public int count1() {
        return userPackageMapper.count1();
    }

}
