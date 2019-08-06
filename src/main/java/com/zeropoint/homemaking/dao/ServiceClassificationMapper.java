package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.ServiceClassification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author Administrator
 */
@Mapper
public interface ServiceClassificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ServiceClassification record);

    ServiceClassification selectByPrimaryKey(Integer id);

    List<ServiceClassification> selectAll();

    int updateByPrimaryKey(ServiceClassification record);

    int deleteByPrimaryKey1(Integer id);

    int insert1(ServiceClassification record);



    List<ServiceClassification> selectAll1();

    List<ServiceClassification> selectPage1(@Param("page")Integer page, @Param("rows")Integer rows);

    int count1();

    ServiceClassification selectByPrimaryKey1(Integer id);

    int updateByPrimaryKey1(ServiceClassification record);

    /*
     * 修改状态
     * */
    int updateStatus1(@Param("id")int id,@Param("status")int status);

    /**
     * 批量删除
     * @param ids id数组
     * @return status
     */
    void delete1(@Param("ids")Integer[] ids);
}