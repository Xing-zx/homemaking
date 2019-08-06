package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.CustomerServiceMapper;
import com.zeropoint.homemaking.domain.CustomerService;
import com.zeropoint.homemaking.services.CustomersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersServiceImpl implements CustomersServices {

    @Autowired
    private CustomerServiceMapper customerServiceMapper;

    @Override
    public int insert(CustomerService record) {
        return customerServiceMapper.insert(record);
    }

    @Override
    public List<CustomerService> selectAll(Integer page,Integer rows){
        return customerServiceMapper.selectAll(page,rows);
    }

    @Override
    public int count(){
        return customerServiceMapper.count();
    }

    @Override
    public int delete(Integer[] ids) {
        return customerServiceMapper.delete(ids);
    }

    @Override
    public int update(Integer id, Integer status) {
        return customerServiceMapper.update(id,status);
    }
}
