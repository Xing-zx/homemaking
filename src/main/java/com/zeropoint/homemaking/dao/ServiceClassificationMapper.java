package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.ServiceClassification;
import java.util.List;

public interface ServiceClassificationMapper {
    int deleteByPrimaryKey(Integer iconId);

    int insert(ServiceClassification record);

    ServiceClassification selectByPrimaryKey(Integer iconId);

    List<ServiceClassification> selectAll();

    int updateByPrimaryKey(ServiceClassification record);
}