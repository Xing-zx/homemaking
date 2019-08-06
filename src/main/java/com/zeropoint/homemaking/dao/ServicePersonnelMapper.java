package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.domain.Stores;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
/**
 * @author Administrator
 */
@Mapper
public interface ServicePersonnelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ServicePersonnel record);

    ServicePersonnel selectByPrimaryKey(Integer id);

    List<ServicePersonnel> selectAll();
    List<ServicePersonnel> selectByCondition(Map<String,Object >condition);

    int updateByPrimaryKey(ServicePersonnel record);

    ServicePersonnel findByUserId(Integer userId);

    int getCountByUpline(Integer upline);

    void delete1(Integer[] ids);

    int insert1(ServicePersonnel record);

    ServicePersonnel selectByPrimaryKey1(Integer id);

    List<ServicePersonnel> selectAll1();

    List<ServicePersonnel> selectByCondition1(int page,int rows,String name,Integer storesId,Integer workType,String startTime,String endTime);

    int count1(String name,Integer storesId,Integer workType,String startTime,String endTime);

    /*未审核员工*/
    List<ServicePersonnel> selectByConditions1(int page,int rows,String name,Integer workType,String startTime,String endTime);

    int counts1(String name,Integer workType,String startTime,String endTime);

    int updateByPrimaryKey1(ServicePersonnel record);

    /*查询单个*/
    ServicePersonnel SelectIds1(Integer id);

    /*获取门店下拉框*/
    List<Stores> selectStores1();


}