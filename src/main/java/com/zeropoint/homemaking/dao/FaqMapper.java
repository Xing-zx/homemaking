package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Faq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface FaqMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Faq record);

    Faq selectByPrimaryKey(Integer id);

    List<Faq> selectAll();

    int updateByPrimaryKey(Faq record);
}