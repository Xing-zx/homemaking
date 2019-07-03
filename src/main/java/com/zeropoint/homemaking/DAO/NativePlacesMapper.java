package com.zeropoint.homemaking.DAO;

import com.zeropoint.homemaking.Entitys.NativePlaces;
import java.util.List;

public interface NativePlacesMapper {
    int insert(NativePlaces record);

    List<NativePlaces> selectAll();
}