package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.ServicePersonnel;
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


}