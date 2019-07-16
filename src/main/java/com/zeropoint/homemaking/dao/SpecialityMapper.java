package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Speciality;
import java.util.List;

public interface SpecialityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Speciality record);

    Speciality selectByPrimaryKey(Integer id);

    List<Speciality> selectAll();

    List<Speciality> selectByPersonnelId();

    int updateByPrimaryKey(Speciality record);
}