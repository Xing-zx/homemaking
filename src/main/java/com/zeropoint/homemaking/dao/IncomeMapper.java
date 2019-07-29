package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Income;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface IncomeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Income record);

    Income selectByPrimaryKey(Integer id);

    List<Income> selectAll();

    int updateByPrimaryKey(Income record);

    List<Income> selectByPersonnelId(Integer personnelId);
    List<Income> selectByPersonnelIdAndDate(Integer personnelId, String date);
}