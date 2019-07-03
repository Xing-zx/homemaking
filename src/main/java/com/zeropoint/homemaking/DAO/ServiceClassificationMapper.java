package com.zeropoint.homemaking.DAO;

import com.zeropoint.homemaking.Entitys.ServiceClassification;
import java.util.List;

public interface ServiceClassificationMapper {
    int insert(ServiceClassification record);

    List<ServiceClassification> selectAll();
}