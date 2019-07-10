package com.zeropoint.homemaking.domain;

import java.util.Date;

public class Lecture {
    private Integer id;

    private String lectureName;

    private String thumbnails;

    private String introduce;

    private String deailed;

    private Double amount;

    private Date coursetime;

    private Date stoptime;

    private String coursesite;

    private Integer stateLecture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(String thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getDeailed() {
        return deailed;
    }

    public void setDeailed(String deailed) {
        this.deailed = deailed;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getCoursetime() {
        return coursetime;
    }

    public void setCoursetime(Date coursetime) {
        this.coursetime = coursetime;
    }

    public Date getStoptime() {
        return stoptime;
    }

    public void setStoptime(Date stoptime) {
        this.stoptime = stoptime;
    }

    public String getCoursesite() {
        return coursesite;
    }

    public void setCoursesite(String coursesite) {
        this.coursesite = coursesite;
    }

    public Integer getStateLecture() {
        return stateLecture;
    }

    public void setStateLecture(Integer stateLecture) {
        this.stateLecture = stateLecture;
    }
}