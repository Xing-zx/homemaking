package com.zeropoint.homemaking.vo;

import com.zeropoint.homemaking.domain.Article;

public class ArticleInfo {
    Article article;
    String[] imgs;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String[] getImgs() {
        return imgs;
    }

    public void setImgs() {
        this.imgs = article.getCoverImgs();
    }
}
