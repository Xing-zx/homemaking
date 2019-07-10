package com.zeropoint.homemaking.domain;

public class ServiceClassification {
    private Integer iconId;

    private String icon;

    private String serviceName;

    private String serviceIntroduced;

    public Integer getIconId() {
        return iconId;
    }

    public void setIconId(Integer iconId) {
        this.iconId = iconId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceIntroduced() {
        return serviceIntroduced;
    }

    public void setServiceIntroduced(String serviceIntroduced) {
        this.serviceIntroduced = serviceIntroduced;
    }
}