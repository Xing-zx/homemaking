package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.UserPackage;

import java.util.List;

public interface UserPackageService {

    List<UserPackage> selectByCondition1(Integer userId);

    int count1();
}
