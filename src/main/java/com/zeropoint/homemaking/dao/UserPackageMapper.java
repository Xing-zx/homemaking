package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.UserPackage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/** 用户套餐卡包DAO
 * @author Administrator
 */
@Mapper
public interface UserPackageMapper {
    /** 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /** 插入
     * @param record
     * @return
     */
    int insert(UserPackage record);

    /** 查询
     * @param id
     * @return
     */
    UserPackage selectByPrimaryKey(Integer id);

    /** 全选
     * @return
     */
    List<UserPackage> selectAll();

    /** 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserPackage record);

    /**
     *  按用户查询
     * @param userId
     * @return
     */
    List<UserPackage> findByUserId(Integer userId);

    List<UserPackage> selectByCondition1(Integer userId);

    int count1();
}