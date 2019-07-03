package com.zeropoint.homemaking.DAO;

import com.zeropoint.homemaking.Entitys.Helpcenter;
import java.util.List;

public interface HelpcenterMapper {
    int insert(Helpcenter record);

    List<Helpcenter> selectAll();
}