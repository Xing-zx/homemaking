package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.BrokerageSetting;

import java.util.List;

public interface BrokerageSettingsService {

    List<BrokerageSetting> selectBrokerageSetting();

    int updatePro(Double usera,Double userb,Double fee,Double balance);
}
