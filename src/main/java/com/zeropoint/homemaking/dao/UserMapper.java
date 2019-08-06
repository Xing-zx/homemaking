package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    List<User> UserSelect1(@Param("page")Integer page, @Param("rows")Integer rows, @Param("name")String name,
                           @Param("endTime")String endTime, @Param("startTime")String startTime);

    int count1(@Param("name")String name,@Param("endTime")String endTime,@Param("startTime")String startTime);

    /**
     * 批量删除
     * @param ids id数组
     * @return status
     */
    void delete1(@Param("ids")Integer[] ids);

    User SelectKey1(@Param("id")Integer id);
}