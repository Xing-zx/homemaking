package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.Address;

import java.util.List;

public interface AddressService {
    int add(Address address);
    int update(Address address);
    List<Address> getList();
    int delete(Integer id );
    int getLast();
}
