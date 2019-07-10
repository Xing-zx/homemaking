package com.zeropoint.homemaking.domain;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userNickname;

    private String userPassword;

    private Integer userGender;

    private Integer userAge;

    private String userPhone;

    private String userAddress;

    private String userPortrait;

    private Integer userPermissions;

    private Date userDuedate;

    private Date childrenBirthday;

    private String motherName;

    private Integer motherAge;

    private String programCode;

    private String userGrade;

    private Integer userUpline;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPortrait() {
        return userPortrait;
    }

    public void setUserPortrait(String userPortrait) {
        this.userPortrait = userPortrait;
    }

    public Integer getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(Integer userPermissions) {
        this.userPermissions = userPermissions;
    }

    public Date getUserDuedate() {
        return userDuedate;
    }

    public void setUserDuedate(Date userDuedate) {
        this.userDuedate = userDuedate;
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

    public String getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    public Integer getUserUpline() {
        return userUpline;
    }

    public void setUserUpline(Integer userUpline) {
        this.userUpline = userUpline;
    }
}