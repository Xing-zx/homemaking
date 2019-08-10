package com.zeropoint.homemaking.domain;

import java.util.Date;

/**
 * @author Administrator
 */
public class LectureOrders {
    private Integer id;

    private Integer lectureId;

    private Integer userId;

    private Date createTime;

    private Integer status;

    private String orderNumber;

    private Double amount;

    private String prepayId;

    private Date payTime;

    private Date registerStart;

    private Date registerEnd;

    private Date activeStart;

    private Date activeEnd;

    private String pictureUrl;

    private String title;

    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getCourseSite() {
        return courseSite;
    }

    public void setCourseSite(String courseSite) {
        this.courseSite = courseSite;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    private String userName;

    private String lectureName;

    private String courseSite;

    private Lecture lecture;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Date getRegisterStart() {
        return registerStart;
    }

    public void setRegisterStart(Date registerStart) {
        this.registerStart = registerStart;
    }

    public Date getRegisterEnd() {
        return registerEnd;
    }

    public void setRegisterEnd(Date registerEnd) {
        this.registerEnd = registerEnd;
    }

    public Date getActiveStart() {
        return activeStart;
    }

    public void setActiveStart(Date activeStart) {
        this.activeStart = activeStart;
    }

    public Date getActiveEnd() {
        return activeEnd;
    }

    public void setActiveEnd(Date activeEnd) {
        this.activeEnd = activeEnd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLectureId() {
        return lectureId;
    }

    public void setLectureId(Integer lectureId) {
        this.lectureId = lectureId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}