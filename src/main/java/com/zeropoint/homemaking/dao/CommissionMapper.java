package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Commission;
import java.util.List;

public interface CommissionMapper {
    int deleteByPrimaryKey(Integer commissionId);

    int insert(Commission record);

    Commission selectByPrimaryKey(Integer commissionId);

    List<Commission> selectAll();

    int updateByPrimaryKey(Commission record);
}