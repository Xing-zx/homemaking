package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Broker;
import com.zeropoint.homemaking.domain.Stores;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoresMapper {
    int insert(Stores record);
    /**
     *  条件查询
     * @param condition  注册时间,姓名,角色
     * @return the admin list
     */
    List<Stores> selectByCondition(@Param("page")Integer page, @Param("rows")Integer rows, @Param("name")String name,
                                   @Param("endTime")String endTime, @Param("startTime")String startTime);

    int count(@Param("name")String name,@Param("endTime")String endTime,@Param("startTime")String startTime);

    int delete(@Param("ids")Integer[] ids);

    Stores SelectAll(@Param("storesId")Integer storesId);

    int updateAll(Stores stores);

    int updateStatus(@Param("storesId")Integer id,@Param("status")Integer status);

    List<Broker> selectBroker();
}