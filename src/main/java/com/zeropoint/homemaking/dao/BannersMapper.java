package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Banners;
import java.util.List;

public interface BannersMapper {
    int deleteByPrimaryKey(Integer bannerId);

    int insert(Banners record);

    Banners selectByPrimaryKey(Integer bannerId);

    List<Banners> selectAll();

    int updateByPrimaryKey(Banners record);
}