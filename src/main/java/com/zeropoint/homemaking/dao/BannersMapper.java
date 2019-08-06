package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Banners;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author Administrator
 */
@Mapper
public interface BannersMapper {
    /**
     *  删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  插入
     * @param record
     * @return
     */
    int insert(Banners record);

    /** 查询
     * @param id
     * @return
     */
    Banners selectByPrimaryKey(Integer id);

    /** 全部列表
     * @return
     */
    List<Banners> selectAll();

    /** 更新/修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(Banners record);

    /**
     *  删除
     * @param id
     * @return
     */
    int delete1(@Param("ids") Integer[] ids);

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
    List<Banners> selectAllPage1(@Param("page")Integer page,@Param("rows")Integer rows);

    int count1();

    /** 更新/修改
     * @param record
     * @return
     */
    int updateByPrimaryKey1(Banners record);


    int update1(@Param("id")Integer id, @Param("status")Integer status);
}