package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.ServicePackageMapper;
import com.zeropoint.homemaking.dao.UserPackageMapper;
import com.zeropoint.homemaking.domain.ServicePackage;
import com.zeropoint.homemaking.domain.UserPackage;
import com.zeropoint.homemaking.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chowhin
 */
@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    ServicePackageMapper servicePackageMapper;
    @Autowired
    UserPackageMapper userPackageMapper;
    @Override
    public List<ServicePackage> getPackageList() {
        return servicePackageMapper.selectAll();
    }

    @Override
    public ServicePackage packageInfo(Integer packageId) {
        return servicePackageMapper.selectByPrimaryKey(packageId);
    }

    @Override
    public List<UserPackage> myPackages(Integer userId) {
        return userPackageMapper.findByUserId(userId);
    }

    @Override
    public UserPackage myPackageInfo(Integer userId, Integer packageId) {
        return userPackageMapper.selectByPrimaryKey(packageId);
    }

    @Override
    public int addUserPackage(UserPackage userPackage) {
        return userPackageMapper.insert(userPackage);
    }
}
