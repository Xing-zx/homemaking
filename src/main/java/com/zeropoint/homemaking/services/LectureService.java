package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.Lecture;

import java.util.List;

public interface LectureService {

    List<Lecture> getList();
    Lecture findLectureById(Integer id);

    int delete1(Integer[] ids);

    int insert1(Lecture record);

    /*查询单个*/
    Lecture selectByPrimaryKey1(Integer id);

    List<Lecture> selectAll1();

    int updateByPrimaryKey1(Lecture record);

    /**
     *  条件查询
     * @param condition  注册时间,姓名,角色
     * @return the admin list
     */
    List<Lecture> selectByCondition1(Integer page,Integer rows,String name,Integer status,String endTime,String startTime);

    int count1(String name,Integer status,String endTime,String startTime);

    int updateStatus1(Integer id,Integer status);


}
