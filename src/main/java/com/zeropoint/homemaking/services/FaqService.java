package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.Faq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FaqService {

    List<Faq> selectPage1(Integer page,Integer rows);

    int count();

    int deleteByPrimaryKey(Integer[] id);

    int insert(Faq record);

    Faq selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Faq record);
}
