package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Article;
import java.util.List;
import java.util.Map;

/** 文章
 * @author zx
 */
public interface ArticleMapper {
    /**
     *  删除
     * @param id
     * @return status
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  插入
     * @param record
     * @return status
     */
    int insert(Article record);

    /**
     *  查询
     * @param id
     * @return status
     */
    Article selectByPrimaryKey(Integer id);

    /**
     * 获取文章列表
     * @return the article list
     */
    List<Article> selectAll();

    /**
     *  更新
     * @param record
     * @return status
     */
    int updateByPrimaryKey(Article record);

    /**
     *  条件查询
     * @param condition 文章内容 发布时间
     * @return the article list
     */
   // List<Article> selectByCondition(Map<String,String> condition);
}