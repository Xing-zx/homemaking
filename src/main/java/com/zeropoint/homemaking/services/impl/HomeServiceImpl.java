package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.BannersMapper;
import com.zeropoint.homemaking.dao.ServiceClassificationMapper;
import com.zeropoint.homemaking.domain.Banners;
import com.zeropoint.homemaking.domain.ServiceClassification;
import com.zeropoint.homemaking.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private ServiceClassificationMapper menu;
    @Autowired
    private BannersMapper bannersMapper;
    @Override
    public List<ServiceClassification> getMenu() {
        return menu.selectAll();
    }

    @Override
    public List<Banners> getSwiper() {
        return bannersMapper.selectAll();
    }
}
