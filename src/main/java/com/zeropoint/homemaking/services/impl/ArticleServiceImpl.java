package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.ArticleMapper;
import com.zeropoint.homemaking.domain.Article;
import com.zeropoint.homemaking.services.ArticleService;

import com.zeropoint.homemaking.vo.ArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Override
    public List<Article> getList() {

        List<Article> articleList =articleMapper.selectAll();

       return articleList;
    }

    @Override
    public Article getInfo(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int countAdd(Article record) {
        return articleMapper.updateByPrimaryKey(record) ;
    }

}
