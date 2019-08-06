package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Broker;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrokerMapper {

    int insert(Broker record);

    /**
     *  条件查询
     * @return the admin list
     */
    List<Broker> selectByCondition(@Param("page")Integer page, @Param("rows")Integer rows, @Param("name")String name,
                                   @Param("endTime")String endTime, @Param("startTime")String startTime);

    int count(@Param("name")String name,@Param("endTime")String endTime,@Param("startTime")String startTime);

    void delete(@Param("ids")Integer[] ids);

    int updateStatus(@Param("id")Integer id,@Param("status")Integer status);

    Broker SelectKey(@Param("id")Integer id);

    int updateAll(Broker broker);
}
