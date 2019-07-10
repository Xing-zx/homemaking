package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.NativePlaces;
import java.util.List;

public interface NativePlacesMapper {
    int deleteByPrimaryKey(Integer nativeId);

    int insert(NativePlaces record);

    NativePlaces selectByPrimaryKey(Integer nativeId);

    List<NativePlaces> selectAll();

    int updateByPrimaryKey(NativePlaces record);
}