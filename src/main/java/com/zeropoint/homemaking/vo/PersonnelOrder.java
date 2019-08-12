package com.zeropoint.homemaking.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zeropoint.homemaking.utils.ConvertUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author chowhin
 */
public class PersonnelOrder {

    /**
     * id: 1,
     * 	title: '李先生需要一位认真负责的阿姨带孩子李先生需要一位认真负责的阿姨带孩子李',//标题
     * 	timeragne: ['2019-07-08 14:00:00', '2019-07-08 18:00:00'], 			//服务时间
     * 	address: '湖南省郴州市北湖区七里大道1栋124', 					//地址
     * 	price: '4930', 									//完服务阿姨一共得到
     * 	remark: '需要温柔贤惠的', 							//备注
     * 	custome_name: '李先生', 							//用户姓名
     * 	custome_phone: '13012341234', 							//用户电话
     * 	custome_sex: 1, 								//1男其它女
     * 	createtime: '2019-08-07', 							//创建时间
     * 	status: 2, 									//2待服务 3,4,5服务中 6已完成
     * 	type: 1,									//1月嫂 2保姆 3终点工 服务类型
     * 	requirement: ['要求1', '要求2', '要求3'], 					//服务要求
     * 	hascomment: false,								//是否已经评价
     */
    private Integer id;

    private String title;

    private Integer type;

    private String userPhone;

    private Integer userId;

    private String orderNumber;

    private String requirement;

    private String hetongImgsrc;

    private Integer status;

    private String address;

    private String remark;

    private Boolean hascomment;

    private Date createTime;

    private String userName;
    @JsonIgnore
    private Date workStartTime;
    @JsonIgnore
    private Date workEndTime;

    private Double moneyActual;

    private Integer userGender;

    public String[] getTimeragne() {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if( workEndTime!=null && workStartTime !=null)
        {
            String str1=df.format(workStartTime);
            String str2=df.format(workEndTime);
            String[] timeragne={str1,str2};
            return timeragne;
        }
        return null;
    }




    @JsonIgnore
    private String province;
    @JsonIgnore
    private String city;
    @JsonIgnore
    private String county;
    @JsonIgnore
    private String street;
    @JsonIgnore
    private String detail;

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String[] getRequirement() {
        return requirement.split(",");
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getHetongImgsrc() {
        return hetongImgsrc;
    }

    public void setHetongImgsrc(String hetongImgsrc) {
        this.hetongImgsrc = hetongImgsrc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddress() {

        return (province!=null?province:"")+" "+(city!=null?city:"")+" "+(county!=null?county:"")+" "+(detail!=null?detail:"");
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getHascomment() {
        return hascomment;
    }

    public void setHascomment(Boolean hascomment) {
        this.hascomment = hascomment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(Date workStartTime) {
        this.workStartTime = workStartTime;
    }

    public Date getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(Date workEndTime) {
        this.workEndTime = workEndTime;
    }


    public Double getMoneyActual() {
        return moneyActual;
    }

    public void setMoneyActual(Double moneyActual) {
        this.moneyActual = moneyActual;
    }
}
