package com.zeropoint.homemaking.domain;

import java.util.Date;

public class Order {
    private Integer orderId;

    private Integer userid;

    private Integer serviceid;

    private Date orderTime;

    private String orderAddress;

    private String orderContent;

    private Integer orderPayment;

    private Integer orderStatus;

    private String orderEvaluation;

    private String orderContract;

    private Integer storesid;

    private Integer commissionid;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    public Integer getOrderPayment() {
        return orderPayment;
    }

    public void setOrderPayment(Integer orderPayment) {
        this.orderPayment = orderPayment;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderEvaluation() {
        return orderEvaluation;
    }

    public void setOrderEvaluation(String orderEvaluation) {
        this.orderEvaluation = orderEvaluation;
    }

    public String getOrderContract() {
        return orderContract;
    }

    public void setOrderContract(String orderContract) {
        this.orderContract = orderContract;
    }

    public Integer getStoresid() {
        return storesid;
    }

    public void setStoresid(Integer storesid) {
        this.storesid = storesid;
    }

    public Integer getCommissionid() {
        return commissionid;
    }

    public void setCommissionid(Integer commissionid) {
        this.commissionid = commissionid;
    }
}