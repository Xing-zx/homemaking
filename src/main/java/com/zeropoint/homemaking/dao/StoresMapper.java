package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Stores;
import java.util.List;

public interface StoresMapper {
    int deleteByPrimaryKey(Integer storesId);

    int insert(Stores record);

    Stores selectByPrimaryKey(Integer storesId);

    List<Stores> selectAll();

    int updateByPrimaryKey(Stores record);
}