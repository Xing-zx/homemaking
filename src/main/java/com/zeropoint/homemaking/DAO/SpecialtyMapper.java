package com.zeropoint.homemaking.DAO;

import com.zeropoint.homemaking.Entitys.Specialty;
import java.util.List;

public interface SpecialtyMapper {
    int insert(Specialty record);

    List<Specialty> selectAll();
}