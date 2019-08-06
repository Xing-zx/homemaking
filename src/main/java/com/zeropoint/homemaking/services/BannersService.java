package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.Banners;

import java.util.List;

public interface BannersService {

    /** 全部列表
     * @return
     */
    List<Banners> selectAll();
    /** 全部列表
     * @return
     */
    List<Banners> selectAllPage(Integer page, Integer rows);

    int count();

    /**
     *  插入
     * @param record
     * @return
     */
    int insert(Banners record);

    /**
     *  删除
     * @param ids
     * @return
     */
    int delete(Integer[] ids);

    int update(Integer id, Integer status);

    Banners selectByPrimaryKey(Integer id);

    /** 更新/修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(Banners record);

    /**
     *  删除
     * @param ids
     * @return
     */
    int delete1(Integer[] ids);

    /**
     *  插入
     * @param record
     * @return
     */
    int insert1(Banners record);

    /** 查询
     * @param id
     * @return
     */
    Banners selectByPrimaryKey1(Integer id);

    /** 全部列表
     * @return
     */
    List<Banners> selectAll1();

    /** 全部列表
     * @return
     */
    List<Banners> selectAllPage1(Integer page,Integer rows);

    int count1();

    /** 更新/修改
     * @param record
     * @return
     */
    int updateByPrimaryKey1(Banners record);


    int update1(Integer id,Integer status);
}
