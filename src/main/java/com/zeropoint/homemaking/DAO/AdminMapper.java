package com.zeropoint.homemaking.DAO;

import com.zeropoint.homemaking.Entitys.Admin;
import java.util.List;

public interface AdminMapper {
    int insert(Admin record);

    List<Admin> selectAll();
}