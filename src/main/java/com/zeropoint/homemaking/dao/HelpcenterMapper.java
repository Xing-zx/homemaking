package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Helpcenter;
import java.util.List;

public interface HelpcenterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Helpcenter record);

    Helpcenter selectByPrimaryKey(Integer id);

    List<Helpcenter> selectAll();

    int updateByPrimaryKey(Helpcenter record);
}