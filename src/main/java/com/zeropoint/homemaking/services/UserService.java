package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.User;

/**
 * @author Administrator
 */
public interface UserService {
    /**
     *  根据openId 查询
     * @param openId
     * @return
     */
    User selectByOpenId(String openId);

    /**
     *  添加用户
     * @param user
     * @return
     */
    int Add(User user);

    /** 查询
     * @param id id
     * @return 用户
     */
    User findUserById(Integer id);

    /**
     *  电话查询用户
     * @param phone
     * @return
     */
    User findUserByPhone(String phone);
}
