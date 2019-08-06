package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Address;
import com.zeropoint.homemaking.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/** 管理员
 * @author zx
 */
@Mapper
public interface AdminMapper {
    /**
     *  删除
     * @param id id
     * @return the status
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入
     * @param record admin
     * @return  status
     */
    int insert(Admin record);

    /**
     * 查询
     * @param id id
     * @return admin
     */
    Admin selectByPrimaryKey(Integer id);

    /**
     * 获取 admin list
     * @return  the admin list
     */
    List<Admin> selectAll();

    /**
     *  更新
     * @param record admin
     * @return the status
     */
    int updateByPrimaryKey(Admin record);

    /**
     *  条件查询
     * @param condition  注册时间,姓名,角色
     * @return the admin list
     */
    List<Admin> selectByCondition(Map<String, String> condition);

    /**
     * 批量删除
     * @param ids id数组
     * @return status
     */
   void delete(@Param("ids")Integer[] ids);

    /**
     *  匹配账号
     * @param name 账号
     * @return admin
     */
      Admin selectByName(String name);

    /**
     *  删除
     * @param id id
     * @return the status
     */
    int deleteByPrimaryKey1(Integer id);

    /**
     * 插入
     * @param record admin
     * @return  status
     */
    int insert1(Admin record);

    /**
     * 单个用户查询
     * @param id id
     * @return admin
     */
    Admin selectByPrimaryKey1(Integer id);

    /**
     * 获取 admin list
     * @return  the admin list
     */
    List<Admin> selectAll1();

    /**
     *  更新
     * @param record admin
     * @return the status
     */
    int updateByPrimaryKey1(Admin record);

    /**
     *  条件查询
     * @return the admin list
     */
    List<Admin> selectByCondition1(@Param("page")Integer page, @Param("rows")Integer rows, @Param("name")String name, @Param("role")String role,
                                   @Param("endTime")String endTime, @Param("startTime")String startTime);

    int AdminCount1(@Param("name")String name,@Param("role")String role,
                    @Param("endTime")String endTime,@Param("startTime")String startTime);

    /**
     * 批量删除
     * @param ids id数组
     * @return status
     */
    void delete1(@Param("ids")Integer[] ids);

    /**
     *  匹配账号
     * @param name 账号
     * @return admin
     */
    Admin selectByName1(String name);

    /**
     *  修改状态
     * @param id id
     * @param status 状态
     * @return admin
     */
    int updateStatus1(@Param(value="id")int id,@Param(value="status")int status);

    Admin login1(Admin admin);

    List<Address> getList(Integer id);



}