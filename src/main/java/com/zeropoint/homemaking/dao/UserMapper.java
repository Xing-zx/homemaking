package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    /**
     *  查询用户根据openId
     * @param openId 唯一标识
     * @return 用户
     */
    User selectByOpenId(String openId);

    User selectByPhone(String phone);
}