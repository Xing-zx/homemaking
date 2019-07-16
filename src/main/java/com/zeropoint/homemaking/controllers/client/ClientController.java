package com.zeropoint.homemaking.controllers.client;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeropoint.homemaking.domain.Article;
import com.zeropoint.homemaking.domain.Lecture;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.services.ArticleService;
import com.zeropoint.homemaking.services.HomeService;
import com.zeropoint.homemaking.services.LectureService;
import com.zeropoint.homemaking.services.PersonnelService;
import com.zeropoint.homemaking.vo.ArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@RestController
public class ClientController {

    @Autowired
     private  HomeService homeService;
    @Autowired
    PersonnelService personnelService;
    @Autowired
    LectureService lectureService;
    @Autowired
    ArticleService articleService;



    /** 主页信息填充和链接
     * @return
     */
    @RequestMapping("/home")
    public JSONObject getHome(){
         System.out.println("receive request");
        JSONObject res = new JSONObject();
        res.put("code",1);
        res.put("msg","home");
        Map< String ,Object> wrapper =new HashMap<>(16);
        wrapper.put("menu",homeService.getMenu());
        wrapper.put("swiper",homeService.getSwiper());
        wrapper.put("speciality",personnelService.getChildList("特长"));
        wrapper.put("certificate",personnelService.getChildList("证书"));
        res.put("data", wrapper);
        return  res;
    }

    /**  阿姨列表
     * @param cond  城市
     * @return 阿姨列表
     */
    @RequestMapping("/personnelList")
    public JSONObject getList(@RequestBody Map<String,Object> cond){
        JSONObject res=new JSONObject();
        res.put("code",1);
        res.put("msg","list");
        System.out.println(cond.toString());
       res.put("data",personnelService.getList(cond));
        return res;
    }

    /**
     *  筛选阿姨
     * @param cond 筛选条件
     * @return 阿姨列表
     */
    @RequestMapping("/filterPersonnel")
    public JSONObject query(@RequestBody Map<String,Object> cond){
        int pageCount=(int)cond.get("pagination");
        PageHelper.startPage(pageCount,8);
        PageInfo<ServicePersonnel> personnelPageInfo = new PageInfo<>(personnelService.getList(cond));
        JSONObject res=new JSONObject();
        if(personnelPageInfo.getSize() >=pageCount )
        {
            res.put("code", 1);
            res.put("msg", "filter");
            System.out.println(cond.toString());
            List<ServicePersonnel> list = personnelPageInfo.getList();
            res.put("data", list);
            System.out.println(list.size());
        }
        else{
            res.put("code",1);
            res.put("msg","there are not more thing");
            res.put("data",null);
        }
        System.out.println(res.toJSONString());
        return res;
    }

    /** 线下课程列表
     * @return 线下课程列表
     */
    @RequestMapping("/lectureList")
    public JSONObject listLecture(){
        System.out.println("listLecture");
        JSONObject res = new JSONObject();
        res.put("code",1);
        res.put("message","lecture");
        res.put("data",lectureService.getList());
        return res;
    }

    /**
     *  文章列表
     * @return 列表
     */
    @RequestMapping("/articleList")
    public JSONObject listArticle(){
        JSONObject res =new JSONObject();
        res.put("code",1);
        res.put("message","articleList");
        List<ArticleInfo> articleInfos =new ArrayList<>();
        List<Article> articles = articleService.getList();
        for(int i=0; i<articles.size();i++)
        {
            ArticleInfo articleInfo = new ArticleInfo();
            articleInfo.setArticle(articles.get(i));
            articleInfo.setImgs();
            articleInfos.add(articleInfo);
        }
        res.put("data",articles);
        return res;
    }
    @RequestMapping("/userLogin")
    public JSONObject login(@RequestBody JSONObject request){
        JSONObject res = new JSONObject();

        return res;
    }





}
