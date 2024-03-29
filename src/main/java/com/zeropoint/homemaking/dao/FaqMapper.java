package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Faq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface FaqMapper {
    int deleteByPrimaryKey(Integer[] id);

    int insert(Faq record);

    Faq selectByPrimaryKey(Integer id);

    List<Faq> selectAll();

    int updateByPrimaryKey(Faq record);

    List<Faq> selectPage1(@Param("page")Integer page, @Param("rows")Integer rows);

    int count();
}