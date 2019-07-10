package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Usercitys;
import java.util.List;

public interface UsercitysMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Usercitys record);

    Usercitys selectByPrimaryKey(Integer id);

    List<Usercitys> selectAll();

    int updateByPrimaryKey(Usercitys record);
}