package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.ServiceOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  套餐卡服务Dao
 * @author Administrator
 */
@Mapper
public interface ServiceOrderMapper {
    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /** 插入
     * @param record
     * @return
     */
    int insert(ServiceOrder record);

    /** 查询
     * @param id
     * @return
     */
    ServiceOrder selectByPrimaryKey(Integer id);

    /** 全选
     * @return
     */
    List<ServiceOrder> selectAll();

    /** 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(ServiceOrder record);
}