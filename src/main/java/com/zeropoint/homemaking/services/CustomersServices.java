package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.CustomerService;

import java.util.List;

public interface CustomersServices {

    int insert(CustomerService record);

    List<CustomerService> selectAll(Integer page, Integer rows);

    int count();

    int delete(Integer[] ids);

    int update(Integer id, Integer status);
}
