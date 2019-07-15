package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.Banners;
import com.zeropoint.homemaking.domain.ServiceClassification;

import java.util.List;

/**
 * @author Administrator
 */
public interface HomeService {


    /** 菜单
     * @return  home Menu
     */
    List<ServiceClassification> getMenu();

    /** 轮播图
     * @return  Swiper
     */
    List<Banners> getSwiper();
}
