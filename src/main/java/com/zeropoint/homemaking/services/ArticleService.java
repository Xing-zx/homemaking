package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.Article;
import com.zeropoint.homemaking.vo.ArticleInfo;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    /**
     *  获取全部文章
     * @return 列表
     */
   List<Article> getList();
}
