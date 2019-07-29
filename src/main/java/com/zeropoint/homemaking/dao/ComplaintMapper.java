package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Complaint;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ComplaintMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Complaint record);

    Complaint selectByPrimaryKey(Integer id);

    List<Complaint> selectAll();

    int updateByPrimaryKey(Complaint record);
}