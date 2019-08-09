package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    Article selectByPrimaryKey(Integer id);

    List<Article> selectAll();

    int updateByPrimaryKey(Article record);

    int delete1(@Param("ids") Integer[] ids);


    int insert1(Article record);

    Article selectKey1(@Param("id")Integer id);

    List<Article> selectAll1();

    int update1(Article record);


    List<Article> selectByCondition1(@Param("page")Integer page, @Param("rows")Integer rows, @Param("title")String title, @Param("author")String author,
                                     @Param("state")Integer state,@Param("startTime") String startTime,@Param("endTime") String endTime);

    int count1(@Param("title")String title, @Param("author")String author,
               @Param("state")Integer state,@Param("startTime") String startTime,@Param("endTime") String endTime);

    /*修改状态*/
    int updatestate1(@Param("id")Integer id,@Param("state")Integer state);

    Article findByTitle(String title);
}