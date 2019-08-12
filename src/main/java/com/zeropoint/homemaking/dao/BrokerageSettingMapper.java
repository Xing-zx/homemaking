package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.BrokerageSetting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrokerageSettingMapper {

    List<BrokerageSetting> selectBrokerageSetting();

    int updatePro(Double usera,Double userb,Double fee,Double balance);
}
