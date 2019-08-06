package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.BrokerageSetting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrokerageSettingMapper {

    int insert(BrokerageSetting record);

    /**
     *  条件查询
     * @param condition  注册时间,姓名,角色
     * @return the admin list
     */
    List<BrokerageSetting> selectByCondition(@Param("page")Integer page, @Param("rows")Integer rows );

    int count();

    int delete(@Param("ids")Integer[] ids);

    BrokerageSetting selectKey(@Param("id")Integer id);

    int update(@Param("id")Integer id,@Param("status")Integer status);
}
