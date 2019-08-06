package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Complaint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ComplaintMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Complaint record);

    Complaint selectByPrimaryKey(Integer id);

    List<Complaint> selectAll();

    int updateByPrimaryKey(Complaint record);

    int insert1(Complaint record);

    List<Complaint> selectAll1();

    List<Complaint> selectPage1(@Param("page")Integer page, @Param("rows")Integer rows);

    int delete1(@Param("ids")Integer[] ids);

    int count1();
}