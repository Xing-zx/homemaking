package com.zeropoint.homemaking.domain;

import java.util.Date;

public class Stores {
    private Integer storesId;

    private String storesPassword;

    private String storesName;

    private String storesAddress;

    private String storesIntroduced;

    private Integer sionsId;

    private Integer brokerId;

    private Integer status;

    private Date creatTime;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStoresId() {
        return storesId;
    }

    public void setStoresId(Integer storesId) {
        this.storesId = storesId;
    }

    public String getStoresPassword() {
        return storesPassword;
    }

    public void setStoresPassword(String storesPassword) {
        this.storesPassword = storesPassword;
    }

    public String getStoresName() {
        return storesName;
    }

    public void setStoresName(String storesName) {
        this.storesName = storesName;
    }

    public String getStoresAddress() {
        return storesAddress;
    }

    public void setStoresAddress(String storesAddress) {
        this.storesAddress = storesAddress;
    }

    public String getStoresIntroduced() {
        return storesIntroduced;
    }

    public void setStoresIntroduced(String storesIntroduced) {
        this.storesIntroduced = storesIntroduced;
    }

    public Integer getSionsId() {
        return sionsId;
    }

    public void setSionsId(Integer sionsId) {
        this.sionsId = sionsId;
    }

    public Integer getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
    }
}