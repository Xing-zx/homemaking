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

    @Override
    public List<ServicePackage> selectPage1(Integer page, Integer rows,String name,Integer status) {
        return servicePackageMapper.selectPage1(page, rows,name,status);
    }

    @Override
    public int count1(String name,Integer status) {
        return servicePackageMapper.count1(name,status);
    }

    @Override
    public int insert(ServicePackage record) {
        System.out.println(record.getType()+"++++++++++++++++++++++++++++");
        return servicePackageMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(ServicePackage record) {
        return servicePackageMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delete(Integer[] ids) {
        return servicePackageMapper.delete(ids);
    }

    @Override
    public ServicePackage selectByPrimaryKey(Integer id) {
        return servicePackageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateStatus(Integer id, Integer status) {
        return servicePackageMapper.updateStatus(id, status);
    }

    @Override
    public List<ServicePackage> selectPage2(Integer type) {
        return servicePackageMapper.selectPage2(type);
    }
}
