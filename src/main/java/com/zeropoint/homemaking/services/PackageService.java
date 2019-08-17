package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.ServicePackage;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.domain.UserPackage;
import org.apache.ibatis.annotations.Param;

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

    /**
     *  添加用户套餐卡
     * @param userPackage
     * @return
     */
    int addUserPackage(UserPackage userPackage);

    List<ServicePackage> selectPage1(Integer page,Integer rows,String name,Integer status);

    int count1(String name,Integer status);

    int insert(ServicePackage record);

    int updateByPrimaryKey(ServicePackage record);

    int delete(Integer[] ids);

    ServicePackage selectByPrimaryKey(Integer id);

    int updateStatus(Integer id,Integer status);

    List<ServicePackage> selectPage2(Integer type);

}
