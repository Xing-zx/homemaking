package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Permissions;
import java.util.List;

public interface PermissionsMapper {
    int deleteByPrimaryKey(Integer sionsId);

    int insert(Permissions record);

    Permissions selectByPrimaryKey(Integer sionsId);

    List<Permissions> selectAll();

    int updateByPrimaryKey(Permissions record);
}