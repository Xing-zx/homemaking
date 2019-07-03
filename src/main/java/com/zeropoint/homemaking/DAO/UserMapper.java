package com.zeropoint.homemaking.DAO;

import com.zeropoint.homemaking.Entitys.User;
import java.util.List;

public interface UserMapper {
    int insert(User record);

    List<User> selectAll();
}