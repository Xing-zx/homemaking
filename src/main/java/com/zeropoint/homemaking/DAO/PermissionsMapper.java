package com.zeropoint.homemaking.DAO;

import com.zeropoint.homemaking.Entitys.Permissions;
import java.util.List;

public interface PermissionsMapper {
    int insert(Permissions record);

    List<Permissions> selectAll();
}