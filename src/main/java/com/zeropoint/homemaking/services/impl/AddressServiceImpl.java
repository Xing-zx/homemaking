package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.AddressMapper;
import com.zeropoint.homemaking.domain.Address;
import com.zeropoint.homemaking.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;
    @Override
    public int add(Address address) {
        return addressMapper.insert(address);
    }

    @Override
    public int update(Address address) {
        return addressMapper.updateByPrimaryKey(address);
    }

    @Override
    public List<Address> getList() {
        return addressMapper.selectAll();
    }

    @Override
    public int delete(Integer id) {
        return addressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int getLast() {
        return addressMapper.getLast();
    }
}
