package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.ServicePackage;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.domain.UserPackage;

import java.util.List;

/** 套餐卡 服务
 * @author Administrator
 */
public interface PackageService {
    /**
     *  套餐卡列表
     * @return
     */
    List<ServicePackage> getPackageList();

    /**
     *  套餐卡详情
     * @param packageId
     * @return
     */
    ServicePackage packageInfo(Integer packageId);

    /**
     *  用户套餐卡包
     * @param userId
     * @return
     */
    List<UserPackage> myPackages(Integer userId);

    /**
     *  我的套餐卡详情
     * @param userId
     * @param packageId
     * @return
     */
    UserPackage myPackageInfo(Integer userId,Integer packageId);


}
