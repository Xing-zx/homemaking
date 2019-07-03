package com.zeropoint.homemaking.Entitys;

public class Commission {
    private Integer commissionId;

    private String membershipGrade;

    private Double commissionRatio;

    public Integer getCommissionId() {
        return commissionId;
    }

    public void setCommissionId(Integer commissionId) {
        this.commissionId = commissionId;
    }

    public String getMembershipGrade() {
        return membershipGrade;
    }

    public void setMembershipGrade(String membershipGrade) {
        this.membershipGrade = membershipGrade;
    }

    public Double getCommissionRatio() {
        return commissionRatio;
    }

    public void setCommissionRatio(Double commissionRatio) {
        this.commissionRatio = commissionRatio;
    }
}