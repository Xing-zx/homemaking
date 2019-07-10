package com.zeropoint.homemaking.domain;

public class LectureOrders {
    private Integer id;

    private Integer lectureid;

    private Integer userId;

    private Integer commissionid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLectureid() {
        return lectureid;
    }

    public void setLectureid(Integer lectureid) {
        this.lectureid = lectureid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCommissionid() {
        return commissionid;
    }

    public void setCommissionid(Integer commissionid) {
        this.commissionid = commissionid;
    }
}