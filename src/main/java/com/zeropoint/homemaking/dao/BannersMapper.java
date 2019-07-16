package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Banners;
import org.apache.ibatis.annotations.Mapper;

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
}