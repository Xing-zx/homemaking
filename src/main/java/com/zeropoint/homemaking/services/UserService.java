package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.User;

import java.util.List;

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
    int update(User user);

    int deleteByPrimaryKey1(Integer id);

    int insert1(User record);

    User selectByPrimaryKey1(Integer id);

    List<User> selectAll1();

    int updateByPrimaryKey1(User record);

    /**
     *  查询用户根据openId
     * @param openId 唯一标识
     * @return 用户
     */
    User selectByOpenId1(String openId);

    User selectByPhone1(String phone);

    /**
     *  条件查询
     * @param condition  注册时间,姓名,角色
     * @return the admin list
     */
    List<User> UserSelect1(Integer page,Integer rows,String name,String endTime,String startTime);

    int count1(String name,String endTime,String startTime);

    /**
     * 批量删除
     * @param ids id数组
     * @return status
     */
    void delete1(Integer[] ids);

    User SelectKey1(Integer id);

    int updateBalance1(Integer id,Integer balance);
}
