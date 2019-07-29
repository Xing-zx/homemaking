package com.zeropoint.homemaking.vo;

import com.zeropoint.homemaking.domain.LectureOrders;
import com.zeropoint.homemaking.domain.Order;

/**
 * @author chowhin
 */
public class PayOrder {
    protected   String orderNumber;
    protected  String  goodName;
    protected  Double amount;
    protected  String  store;

    public PayOrder(Order order) {
        this.orderNumber = order.getOrderNumber();


    }
    public PayOrder(LectureOrders orders)
    {
        this.orderNumber = orders.getOrderNumber();

    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
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

}
