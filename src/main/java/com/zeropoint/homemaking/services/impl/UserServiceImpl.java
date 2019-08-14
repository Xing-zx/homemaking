package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.UserMapper;
import com.zeropoint.homemaking.domain.User;
import com.zeropoint.homemaking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
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

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int deleteByPrimaryKey1(Integer id) {
        return userMapper.deleteByPrimaryKey1(id);
    }

    @Override
    public int insert1(User record) {
        return userMapper.insert1(record);
    }

    @Override
    public User selectByPrimaryKey1(Integer id) {
        return userMapper.selectByPrimaryKey1(id);
    }

    @Override
    public List<User> selectAll1() {
        return userMapper.selectAll1();
    }

    @Override
    public int updateByPrimaryKey1(User record) {
        return userMapper.updateByPrimaryKey1(record);
    }

    @Override
    public User selectByOpenId1(String openId) {
        return userMapper.selectByOpenId1(openId);
    }

    @Override
    public User selectByPhone1(String phone) {
        return userMapper.selectByPhone1(phone);
    }

    @Override
    public List<User> UserSelect1(Integer page, Integer rows, String name, String endTime, String startTime) {
        return userMapper.UserSelect1(page, rows, name, endTime, startTime);
    }

    @Override
    public int count1(String name, String endTime, String startTime) {
        return userMapper.count1(name, endTime, startTime);
    }

    @Override
    public void delete1(Integer[] ids) {
        userMapper.delete1(ids);
    }

    @Override
    public User SelectKey1(Integer id) {
        return userMapper.SelectKey1(id);
    }

    @Override
    public int updateBalance1(Integer id, Integer balance) {
        return userMapper.updateBalance1(id,balance);
    }
}
