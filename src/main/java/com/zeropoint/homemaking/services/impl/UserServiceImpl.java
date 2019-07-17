package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.UserMapper;
import com.zeropoint.homemaking.domain.User;
import com.zeropoint.homemaking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User selectByOpenId(String openId) {
        return userMapper.selectByOpenId(openId);
    }
    @Override
    public int Add(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User findUserByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }

}
