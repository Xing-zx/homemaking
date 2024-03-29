package com.zeropoint.homemaking.domain;

import java.util.Date;
import java.util.List;

public class ServicePersonnel {
    private Integer id;

    private String name;

    private String password;

    private String realName;

    private String idcard;

    private Integer age;

    private Integer gender;

    private String phone;

    private String nativePlace;

    private Integer workExperience;

    private String workContent;

    private Integer workType;

    private String workCity;

    private String level;

    private Integer chargeStandard;

    private Double applauseRate;

    private String photoUrl;

    private String videoUrl;

    private String profile;

    private Integer storesId;

    private Integer status;

    private String programCode;

    private Integer upline;

    private Integer upupline;

    private Date creatTimes;

    private Integer count;

    private Double balance;

    private Double currentBrokerage;

    private Integer userId;

    private Integer schedule;

    private Double allBrokerage;

    private Double withdrawalBrokerage;

    private String myself;

    private List<String > specialities;

    private List<String > certificates;

    public String getStoresName() {
        return storesName;
    }

    public void setStoresName(String storesName) {
        this.storesName = storesName;
    }

    private String storesName;

    public ServicePersonnel() {
        this.name = "";
        this.balance = 0.0;
        this.currentBrokerage = 0.0;
        this.allBrokerage = 0.0;
        this.withdrawalBrokerage = 0.0;
        this.chargeStandard=0;
        this.applauseRate=5.0;
        this.workType=3;
        this.creatTimes=new Date();
    }

    public ServicePersonnel(User user) {
        this.name = user.getName();
        this.password = user.getPassword();
        this.age = user.getAge();
        this.gender = user.getGender();
        this.phone = user.getPhone();
        this.workType = 3;
        this.status = 0;
        this.workCity=user.getAddress();
        this.userId = user.getId();
        this.allBrokerage = 0.0;
        this.withdrawalBrokerage = 0.0;
        this.balance = 0.0;
        this.currentBrokerage = 0.0;
        this.chargeStandard=0;
        this.applauseRate=5.0;
        this.photoUrl = user.getPortraitUrl();
        this.createTime = new Date();
    }

    private String certificateName;

    private String pictureUrl;

    private Integer personnelId;

    private Date createTime;

    private Date expirationTime;

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Integer getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(Integer personnelId) {
        this.personnelId = personnelId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public List<String> getCertificates() { return certificates; }

    public void setCertificates(List<String > certificates) { this.certificates = certificates; }

    public List<String> getSpecialities() { return specialities; }

    public void setSpecialities(List<String> specialities) {
            this.specialities = specialities;
        }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public Integer getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Integer workExperience) {
        this.workExperience = workExperience;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public String getWorkCity() {
        return workCity;
    }

    public void setWorkCity(String workCity) {
        this.workCity = workCity;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getChargeStandard() {
        return chargeStandard;
    }

    public void setChargeStandard(Integer chargeStandard) {
        this.chargeStandard = chargeStandard;
    }

    public Double getApplauseRate() {
        return applauseRate;
    }

    public void setApplauseRate(Double applauseRate) {
        this.applauseRate = applauseRate;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Integer getStoresId() {
        return storesId;
    }

    public void setStoresId(Integer storesId) {
        this.storesId = storesId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public Integer getUpline() {
        return upline;
    }

    public void setUpline(Integer upline) {
        this.upline = upline;
    }

    public Integer getUpupline() {
        return upupline;
    }

    public void setUpupline(Integer upupline) {
        this.upupline = upupline;
    }

    public Date getCreatTimes() {
        return creatTimes;
    }

    public void setCreatTimes(Date creatTimes) {
        this.creatTimes = creatTimes;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getCurrentBrokerage() {
        return currentBrokerage;
    }

    public void setCurrentBrokerage(Double currentBrokerage) {
        this.currentBrokerage = currentBrokerage;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSchedule() {
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
    }

    public Double getAllBrokerage() {
        return allBrokerage;
    }

    public void setAllBrokerage(Double allBrokerage) {
        this.allBrokerage = allBrokerage;
    }

    public Double getWithdrawalBrokerage() {
        return withdrawalBrokerage;
    }

    public void setWithdrawalBrokerage(Double withdrawalBrokerage) {
        this.withdrawalBrokerage = withdrawalBrokerage;
    }

    public String getMyself() {
        return myself;
    }

    public void setMyself(String myself) {
        this.myself = myself;
    }
}