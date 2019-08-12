package com.zeropoint.homemaking.domain;

import com.zeropoint.homemaking.services.PackageService;

import java.util.Date;

/**
 * @author Administrator
 */
public class UserPackage {
    private Integer id;

    private Integer userId;

    private Integer packageId;

    private Date createTime;

    private Date expireTime;

    private Integer currentCount;

    private Integer totalCount;

    public UserPackage(ServicePackage servicePackage,Integer userId) {
        this.userId =userId ;
        this.packageId = servicePackage.getId();
        this.createTime = new Date();
        this.expireTime = null;
        this.currentCount = servicePackage.getUseCount();
        this.totalCount = servicePackage.getUseCount();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(Integer currentCount) {
        this.currentCount = currentCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}