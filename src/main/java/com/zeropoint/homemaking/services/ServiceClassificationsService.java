package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.ServiceClassification;

import java.util.List;


public interface ServiceClassificationsService {

    /*
    * 查询全部
    * */
    List<ServiceClassification> selectAll();

    /*
     * 修改状态
     * */
    int updateStatus(int id, int status);

    /**
     * 批量删除
     * @param ids id数组
     * @return status
     */
    void delete(Integer[] ids);

    List<ServiceClassification> selectPage(Integer page, Integer rows);

    int count();

    int insert(ServiceClassification record);

    ServiceClassification selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(ServiceClassification record);

    int deleteByPrimaryKey1(Integer id);

    int insert1(ServiceClassification record);



    List<ServiceClassification> selectAll1();

    List<ServiceClassification> selectPage1(Integer page,Integer rows);

    int count1();

    ServiceClassification selectByPrimaryKey1(Integer id);

    int updateByPrimaryKey1(ServiceClassification record);

    /*
     * 修改状态
     * */
    int updateStatus1(int id,int status);

    /**
     * 批量删除
     * @param ids id数组
     * @return status
     */
    void delete1(Integer[] ids);
}
