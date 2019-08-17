package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.ServicePackage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

/** 套餐卡Dao
 * @author Administrator
 */
@Mapper
public interface ServicePackageMapper {
    /** 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /** 插入
     * @param record
     * @return
     */
    int insert(ServicePackage record);

    /** 查询
     * @param id
     * @return
     */
    ServicePackage selectByPrimaryKey(Integer id);

    /** 全选
     * @return
     */
    List<ServicePackage> selectAll();

    /** 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(ServicePackage record);

    List<ServicePackage> selectPage1(@Param("page")Integer page, @Param("rows")Integer rows,String name,Integer status);

    int count1(String name,Integer status);

    int delete(@Param("ids")Integer[] ids);

    int updateStatus(Integer id,Integer status);

    List<ServicePackage> selectPage2(@Param("type") Integer type);
}