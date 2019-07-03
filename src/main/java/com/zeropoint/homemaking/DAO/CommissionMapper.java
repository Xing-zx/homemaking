package com.zeropoint.homemaking.DAO;

import com.zeropoint.homemaking.Entitys.Commission;
import java.util.List;

public interface CommissionMapper {
    int insert(Commission record);

    List<Commission> selectAll();
}