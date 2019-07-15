package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.ServiceClassification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ServiceClassificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ServiceClassification record);

    ServiceClassification selectByPrimaryKey(Integer id);

    List<ServiceClassification> selectAll();

    int updateByPrimaryKey(ServiceClassification record);
}