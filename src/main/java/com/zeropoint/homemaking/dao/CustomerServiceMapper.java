package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.CustomerService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerServiceMapper {

    int insert(CustomerService record);

    List<CustomerService> selectAll(@Param("page")Integer page, @Param("rows")Integer rows);

    int count();

    int delete(@Param("ids")Integer[] ids);

    int update(@Param("id")Integer id,@Param("status")Integer status);
}
