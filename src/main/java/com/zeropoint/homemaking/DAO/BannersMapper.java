package com.zeropoint.homemaking.DAO;

import com.zeropoint.homemaking.Entitys.Banners;
import java.util.List;

public interface BannersMapper {
    int insert(Banners record);

    List<Banners> selectAll();
}