package com.zeropoint.homemaking.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zeropoint.homemaking.domain.Order;
import com.zeropoint.homemaking.utils.ConvertUtil;
import org.springframework.beans.BeanUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chowhin
 */
public class UserOder {
/**
 * id: 1,
 * 	anut_id:1,				//阿姨id
 * 	title: '李先生需要一位认真负责的阿姨带孩子李先生需要一位认真负责的阿姨带孩子李先生需要一位认真负责的阿姨带孩子', //标题
 * 	timeragne: ['2019-07-08 14:00:00', '2019-07-08 18:00:00'], 	//服务时间
 * 	aunt_name: '王阿姨', 						//阿姨姓名
 * 	aunt_phone: '13012341234', 					//阿姨电话
 * 	aunt_sex: 0, 							//1男其它女
 * 	createtime: '2019-08-07', 					//创建时间
 * 	money_hour:	 0,						//小时/元 (作用终点工)
 * 	money_bargin: 20,						//定金	  (作用月嫂)
 * 	money_advance: 4120,						//预付款  (作用保姆月嫂)
 * 	money_final: 4000,						//尾款	  (作用保姆月嫂)
 * 	money_total: 8140,						//全款    (作用全部)
 * 	status: 3, 							//1待预约 2待服务 (3待付定金 4待付预付款 5待付尾款)==服务中 6完成 -1取消
 * 	type: 1, 							//1月嫂 2保姆 3终点工
 * 	requirement: ['要求1', '要求2', '要求3'], 			//服务要求
 * 	hascomment: false,
 */
private Integer id;

    private String title;

    private Integer type;

    private Integer personnelId;

    private String orderNumber;

    private String requirement;

    private String hetongImgsrc;

    private Integer status;

    private String address;

    private String remark;

    private Boolean hascomment;

    private Date createTime;

    private Integer moneyHour;

    private Double moneyBargin;

    private Double moneyAdvance;

    private Double moneyFinal;

    private Double moneyTotal;

    private String personnelName;
    @JsonIgnore
    private Date workStartTime;
    @JsonIgnore
    private Date workEndTime;

    private Date payTime;

    private Integer addressId;

    @JsonIgnore
    private String assignIds;

    private String nativePlace;

    private String personnelPhone;

    private Integer personnelGender;

    public Date getAppiontDate() {
        return appiontDate;
    }

    public void setAppiontDate(Date appiontDate) {
        this.appiontDate = appiontDate;
    }

    private Date appiontDate;



    public String getPersonnelPhone() {
        return personnelPhone;
    }

    public void setPersonnelPhone(String personnelPhone) {
        this.personnelPhone = personnelPhone;
    }

    public Integer getPersonnelGender() {
        return personnelGender;
    }

    public void setPersonnelGender(Integer personnelGender) {
        this.personnelGender = personnelGender;
    }

    private String requireAge;

    private String requireExpirence;

    public String getRequireAge() {
        return requireAge;
    }

    public void setRequireAge(String requireAge) {
        this.requireAge = requireAge;
    }

    public String getRequireExpirence() {
        return requireExpirence;
    }

    public void setRequireExpirence(String requireExpirence) {
        this.requireExpirence = requireExpirence;
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



    public Integer getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(Integer personnelId) {
        this.personnelId = personnelId;
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

    public Integer getMoneyHour() {
        return moneyHour;
    }

    public void setMoneyHour(Integer moneyHour) {
        this.moneyHour = moneyHour;
    }

    public Double getMoneyBargin() {
        return moneyBargin;
    }

    public void setMoneyBargin(Double moneyBargin) {
        this.moneyBargin = moneyBargin;
    }

    public Double getMoneyAdvance() {
        return moneyAdvance;
    }

    public void setMoneyAdvance(Double moneyAdvance) {
        this.moneyAdvance = moneyAdvance;
    }

    public Double getMoneyFinal() {
        return moneyFinal;
    }

    public void setMoneyFinal(Double moneyFinal) {
        this.moneyFinal = moneyFinal;
    }

    public Double getMoneyTotal() {
        return moneyTotal;
    }

    public void setMoneyTotal(Double moneyTotal) {
        this.moneyTotal = moneyTotal;
    }

    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName;
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

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAssignIds() {
        return assignIds;
    }

    public void setAssignIds(String assignIds) {
        this.assignIds = assignIds;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }


}