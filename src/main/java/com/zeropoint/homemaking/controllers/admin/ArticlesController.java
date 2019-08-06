package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Article;
import com.zeropoint.homemaking.services.ArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticlesController {

    @Autowired
    private ArticleService articleservice;

    /** 文章列表/查询
     * @return   the list
     */
    @RequestMapping("/list")
    public Map<String, Object> listAdmin(@Param("curr")Integer curr, @Param("limit")Integer limit, @Param("title")String title, @Param("author")String author,
                                         @Param("state")Integer state, @Param("startTime") String startTime, @Param("endTime") String endTime) {
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<Article> articleList=articleservice.selectByCondition1(page,limit,title,author,state,startTime,endTime);

        int count=articleservice.count1(title,author,state,startTime,endTime);
        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "数据返回成功");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", count);
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", articleList);
        //返回给前端

        String json=JSONObject.toJSONString(tableData);
        System.out.println(json);
        return tableData;
    }

    @RequestMapping("/insert")
    public int insert(@RequestBody JSONObject conJson){
        Article article=new Article();
        article.setTitle(conJson.getString("title"));
        article.setAuthor(conJson.getString("author"));
        article.setTime(new Date());
        article.setViews(0);
        article.setContent(conJson.getString("content"));
        article.setState(1);

        return articleservice.insert1(article);
    }

    @RequestMapping("/update")
    public int update(@RequestBody JSONObject conJson){
        Article article=new Article();
        article.setId(conJson.getInteger("id"));
        article.setTitle(conJson.getString("title"));
        article.setAuthor(conJson.getString("author"));
        article.setTime(conJson.getDate("time"));
        article.setViews(conJson.getInteger("views"));
        article.setContent(conJson.getString("content"));
        article.setState(conJson.getInteger("state"));

        return articleservice.update1(article);
    }

    @RequestMapping("/updatestate")
    public int updatestate(@Param("id")Integer id, @Param("state")Integer state){
        return articleservice.updatestate1(id,state);
    }

    @RequestMapping ("/delete")
    @ResponseBody
    public void delete(@RequestParam(value="ids")Integer[] ids){
        System.out.println(ids+"------------------------------------");
        articleservice.delete1(ids);
    }

    @RequestMapping ("/selectKey")
    @ResponseBody
    public Article selectKey(@Param("id")Integer id){
        return articleservice.selectKey1(id);
    }
}
