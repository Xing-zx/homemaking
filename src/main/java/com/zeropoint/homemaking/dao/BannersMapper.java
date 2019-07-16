package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Banners;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BannersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Banners record);

    Banners selectByPrimaryKey(Integer id);

    List<Banners> selectAll();

    int updateByPrimaryKey(Banners record);
}