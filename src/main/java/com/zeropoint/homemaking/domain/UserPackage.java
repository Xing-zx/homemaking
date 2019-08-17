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

    private Integer type;

    private Integer status;

    private String name;

    private String introduce;

    private Double price;

    private Integer useCount;

    private String imgSrc;

    private String specifications;

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public UserPackage(ServicePackage servicePackage, Integer userId) {
        System.out.println("进入");
        this.userId =userId ;
        this.packageId = servicePackage.getId();
        this.createTime = new Date();
        this.expireTime = null;
        this.currentCount = servicePackage.getUseCount();
        this.totalCount = servicePackage.getUseCount();
    }

    public UserPackage(){}

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