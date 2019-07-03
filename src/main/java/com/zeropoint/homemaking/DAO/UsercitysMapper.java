package com.zeropoint.homemaking.DAO;

import com.zeropoint.homemaking.Entitys.Usercitys;
import java.util.List;

public interface UsercitysMapper {
    int insert(Usercitys record);

    List<Usercitys> selectAll();
}