package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.BrokerageSettingMapper;
import com.zeropoint.homemaking.domain.BrokerageSetting;
import com.zeropoint.homemaking.services.BrokerageSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrokerageSttingsServiceImpl implements BrokerageSettingsService {

    @Autowired
    private BrokerageSettingMapper brokerage;


    @Override
    public List<BrokerageSetting> selectBrokerageSetting() {
        return brokerage.selectBrokerageSetting();
    }

    @Override
    public int updatePro(Double usera,Double userb,Double fee,Double balance) {
        System.out.println(usera+"------------"+userb+"=============="+fee+"-----------------"+balance);
        return brokerage.updatePro(usera,userb,fee,balance);
    }
}
