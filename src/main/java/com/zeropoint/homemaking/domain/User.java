package com.zeropoint.homemaking.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zeropoint.homemaking.services.TokenService;

import java.util.Date;

public class User {
    private Integer id;

    private String name;

    private String nickName;

    private String password;

    private Integer gender;

    private Integer age;

    private String phone;

    private String address;

    private String portraitUrl;

    private Date dueDate;

    private Date childrenBirthday;

    private String motherName;

    private Integer motherAge;

    private String programCode;

    private Integer upline;

    private Integer upupline;

    private Integer balance;

    private Integer brokerage;

    private String openId;

    private Date createTime;

    private int Status;

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getChildrenBirthday() {
        return childrenBirthday;
    }

    public void setChildrenBirthday(Date childrenBirthday) {
        this.childrenBirthday = childrenBirthday;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Integer getMotherAge() {
        return motherAge;
    }

    public void setMotherAge(Integer motherAge) {
        this.motherAge = motherAge;
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

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(Integer brokerage) {
        this.brokerage = brokerage;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
        public String getToken(){
            return TokenService.getToken(this);
        }

}