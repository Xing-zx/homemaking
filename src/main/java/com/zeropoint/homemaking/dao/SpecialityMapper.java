package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Speciality;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SpecialityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Speciality record);

    Speciality selectByPrimaryKey(Integer id);

    List<Speciality> selectAll();

    List<Speciality> selectByPersonnelId(Integer id);

    Speciality selectByCategoryIdAndPersonnelId(Integer categoryId,Integer personnelId);

    int updateByPrimaryKey(Speciality record);

    int deleteBunchByPersonnelId(Integer personnelId);

}