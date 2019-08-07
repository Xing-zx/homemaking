package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Financial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FinancialMapper {
    int insert(Financial record);

    List<Financial> selectAll();

    /**
     *  条件查询
     * @param condition  注册时间,姓名,角色
     * @return the admin list
     */
    List<Financial> selectByCondition(@Param("page")Integer page, @Param("rows")Integer rows, @Param("name")String name, @Param("orderType")Integer orderType,
                                      @Param("startTime") String startTime, @Param("endTime") String endTime);

    int count(@Param("name")String name, @Param("orderType")Integer orderType,
              @Param("startTime") String startTime,@Param("endTime") String endTime);

    int delete(@Param("ids")Integer[] ids);

    Financial selectKey(@Param("id")Integer id);
}