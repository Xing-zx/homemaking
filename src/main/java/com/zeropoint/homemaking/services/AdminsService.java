package com.zeropoint.homemaking.services;



import com.zeropoint.homemaking.domain.Admin;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


/**
 * @author Administrator
 */
public interface AdminsService extends UserDetailsService {

    /** 筛选列表
     * @param condition  筛选条件
     * @return the admin list
     */
     List<Admin> selectAll(Integer page, Integer rows, String name, String role, String endTime, String startTime);

    int AdminCount(String name, String role, String endTime, String startTime);

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
     * 查询单个用户
     * @param id id
     * @return admin
     */
    Admin selectByPrimaryKey(Integer id);

    /**
     *  修改状态
     * @param id id
     * @param status 状态
     * @return admin
     */
    int updateStatus(int id, int status);

    Admin login(Admin admin);






}
