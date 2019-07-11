package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Admin;
import org.apache.ibatis.annotations.Mapper;

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
   int deleteByIds(Integer[] ids);

    /**
     *  匹配账号
     * @param name 账号
     * @return admin
     */
      Admin selectByName(String name);

}