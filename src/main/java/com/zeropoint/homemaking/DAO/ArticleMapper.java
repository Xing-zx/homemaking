package com.zeropoint.homemaking.DAO;

import com.zeropoint.homemaking.Entitys.Article;
import java.util.List;

public interface ArticleMapper {
    int insert(Article record);

    List<Article> selectAll();
}