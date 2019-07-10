package com.zeropoint.homemaking.Services.impl;

import com.zeropoint.homemaking.dao.AdminMapper;
import com.zeropoint.homemaking.da.UserMapper;
import com.zeropoint.homemaking.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        List<User> list=userMapper.selectAll();
        return list;
    }

    @Override
    public int add(User user) {
       return userMapper.insert(user);
    }

    public int delete(int key) {
        return userMapper.deleteByPrimaryKey(key);
    }

    @Override
    public List<User> search(Map<String, String> condition) {

        return userMapper.selectByQuery(condition);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
