package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.Article;
import com.zeropoint.homemaking.vo.ArticleInfo;

import java.util.List;
import java.util.Map;

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
}
