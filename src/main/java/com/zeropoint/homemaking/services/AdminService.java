package com.zeropoint.homemaking.services;



import com.zeropoint.homemaking.domain.Admin;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;


/**
 * @author Administrator
 */
public interface AdminService extends UserDetailsService {

    /** 筛选列表
     * @param condition  筛选条件
     * @return the admin list
     */
     List<Admin> selectAll(Map<String,String> condition);

    /** 添加
     * @param record  admin
     * @return 执行结果
     */
     String add(Admin record);

    /** 删除
     * @param ids id数组
     * @return
     */
    void delete(Integer[] ids);

    /** 修改
     * @param  record  修改的内容
     * @return status
     */
     String update(Admin record);


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
    List<Admin> selectByCondition1(Integer page,Integer rows,String name,String role,String endTime,String startTime);

    int AdminCount1(String name,String role,String endTime,String startTime);

    /**
     * 批量删除
     * @param ids id数组
     * @return status
     */
    void delete1(Integer[] ids);

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
    int updateStatus1(int id,int status);

    Admin login1(Admin admin);





}
