package com.zeropoint.homemaking.DAO;

import com.zeropoint.homemaking.Entitys.Stores;
import java.util.List;

public interface StoresMapper {
    int insert(Stores record);

    List<Stores> selectAll();
}