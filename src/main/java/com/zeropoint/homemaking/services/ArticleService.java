package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.Article;

import java.util.List;

/**
 * @author Administrator
 */
public interface ArticleService {
    /**
     *  获取全部文章
     * @return 列表
     */
   List<Article> getList();

    /**
     *  文章详情
     * @param id 文章id
     * @return 文章对象
     */
   Article getInfo(Integer id);

   int  countAdd(Article record);


    int delete1(Integer[] ids);


    int insert1(Article record);

    Article selectKey1(Integer id);

    List<Article> selectAll1();

    int update1(Article record);

    /**
     *  条件查询
     * @param condition  注册时间,姓名,角色
     * @return the admin list
     */
    List<Article> selectByCondition1(Integer page,Integer rows,String title,String author,Integer state,String startTime,String endTime);

    int count1(String title,String author,Integer state,String startTime,String endTime);

    /*修改状态*/
    int updatestate1(Integer id,Integer state);
}
