package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.ServicePersonnel;
import java.util.List;

public interface ServicePersonnelMapper {
    int deleteByPrimaryKey(Integer serviceId);

    int insert(ServicePersonnel record);

    ServicePersonnel selectByPrimaryKey(Integer serviceId);

    List<ServicePersonnel> selectAll();

    int updateByPrimaryKey(ServicePersonnel record);
}