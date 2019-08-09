package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.ArticleMapper;
import com.zeropoint.homemaking.domain.Article;
import com.zeropoint.homemaking.services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author Administrator
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
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

    @Override
    public int delete1(Integer[] ids) {
        return articleMapper.delete1(ids);
    }

    @Override
    public int insert1(Article record) {
        return articleMapper.insert1(record);
    }

    @Override
    public Article selectKey1(Integer id) {
        return articleMapper.selectKey1(id);
    }

    @Override
    public List<Article> selectAll1() {
        return articleMapper.selectAll1();
    }

    @Override
    public int update1(Article record) {
        return articleMapper.update1(record);
    }

    @Override
    public List<Article> selectByCondition1(Integer page, Integer rows, String title, String author, Integer state, String startTime, String endTime) {
        return articleMapper.selectByCondition1(page, rows, title, author, state, startTime, endTime);
    }

    @Override
    public int count1(String title, String author, Integer state, String startTime, String endTime) {
        return articleMapper.count1(title, author, state, startTime, endTime);
    }

    @Override
    public int updatestate1(Integer id, Integer state) {
        return articleMapper.updatestate1(id, state);
    }

    @Override
    public Article findByTitle(String title) {
        return articleMapper.findByTitle(title);
    }

}
