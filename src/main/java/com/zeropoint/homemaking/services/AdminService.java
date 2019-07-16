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








}
