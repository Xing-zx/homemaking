package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Specialty;
import java.util.List;

public interface SpecialtyMapper {
    int deleteByPrimaryKey(Integer specialtyId);

    int insert(Specialty record);

    Specialty selectByPrimaryKey(Integer specialtyId);

    List<Specialty> selectAll();

    int updateByPrimaryKey(Specialty record);
}