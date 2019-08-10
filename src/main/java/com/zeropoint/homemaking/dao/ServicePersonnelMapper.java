package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.domain.Stores;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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



    void delete1(@Param("ids") Integer[] ids);

    int insert1(ServicePersonnel record);

    ServicePersonnel selectByPrimaryKey1(Integer id);

    List<ServicePersonnel> selectAll1();

    List<ServicePersonnel> selectByCondition1(@Param("page")int page,@Param("rows") int rows,@Param("name")String name,
                                              @Param("storesId") Integer storesId,@Param("workType") Integer workType,@Param("startTime") String startTime,@Param("endTime") String endTime);

    int count1(@Param("name")String name, @Param("storesId") Integer storesId, @Param("workType") Integer workType, @Param("startTime") String startTime, @Param("endTime") String endTime);

    /*未审核员工*/
    List<ServicePersonnel> selectByConditions2(@Param("page")int page,@Param("rows") int rows,@Param("name")String name,
                                               @Param("workType") Integer workType,@Param("startTime") String startTime,@Param("endTime") String endTime);

    int counts2(@Param("name")String name,@Param("workType") Integer workType,@Param("startTime") String startTime,@Param("endTime") String endTime);

    int updateByPrimaryKey1(ServicePersonnel record);

    /*查询单个*/
    ServicePersonnel SelectIds1(@Param("id")Integer id);

    /*获取门店下拉框*/
    List<Stores> selectStores1();

    int updateStatus(Integer id,Integer status,Integer storesId);
}