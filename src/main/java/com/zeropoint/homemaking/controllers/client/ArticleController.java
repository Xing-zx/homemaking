package com.zeropoint.homemaking.controllers.client;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Article;
import com.zeropoint.homemaking.services.ArticleService;
import com.zeropoint.homemaking.vo.ArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     *  文章列表
     * @return 列表
     */
    @RequestMapping("/articleList")
    public JSONObject listArticle(){
        JSONObject res =new JSONObject();
        res.put("code",1);
        res.put("message","articleList");
        List<Article> articles = articleService.getList();
        res.put("data",articles);
        return res;
    }

    /**
     *  文章详情
     * @param request
     * @return
     */
    @RequestMapping("/articleInfo")
    public JSONObject articleInfo(@RequestBody JSONObject request){
    JSONObject res =new JSONObject();
    res.put("code",1);
    res.put("msg","articleInfo");
    System.out.println(request.toJSONString());
    Integer id =request.getInteger("id");
    Article article =articleService.getInfo(id);
    res.put("data",article);
    System.out.println(res.toJSONString());
    Integer views =article.getViews();
    int count=views.intValue()+1;
    article.setViews(count);
    articleService.countAdd(article);
    return res;
    }
}
