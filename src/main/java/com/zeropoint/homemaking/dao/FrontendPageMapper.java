package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.FrontendPage;
import java.util.List;

public interface FrontendPageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FrontendPage record);

    FrontendPage selectByPrimaryKey(Integer id);

    List<FrontendPage> selectAll();

    int updateByPrimaryKey(FrontendPage record);
}