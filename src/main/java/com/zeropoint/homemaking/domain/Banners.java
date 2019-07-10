package com.zeropoint.homemaking.domain;

public class Banners {
    private Integer bannerId;

    private String banner;

    private String bannerAddress;

    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getBannerAddress() {
        return bannerAddress;
    }

    public void setBannerAddress(String bannerAddress) {
        this.bannerAddress = bannerAddress;
    }
}