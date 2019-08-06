package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Banners;
import com.zeropoint.homemaking.services.BannersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/banner")
public class BannersaController {

    @Autowired
    private BannersService bannerservice;

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> selectAll(@RequestParam("curr")Integer curr, @RequestParam("limit") Integer limit){
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<Banners> adminlist=bannerservice.selectAllPage(page,limit);

        int count=bannerservice.count();
        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "数据返回成功");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", count);
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", adminlist);
        //返回给前端

        String json=JSONObject.toJSONString(tableData);
        System.out.println(json);
        return tableData;
    }

    @RequestMapping("insert")
    @ResponseBody
    public int insert(@RequestBody JSONObject json){
        Banners banners=new Banners();
        banners.setName(json.getString("name"));
        banners.setPictureUrl(json.getString("img"));
        banners.setUrlId(json.getInteger("url"));
        banners.setArticleId(json.getInteger("articleId"));
        banners.setStatus(json.getInteger("status"));
        return bannerservice.insert(banners);
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(@Param("ids")Integer[] ids){
        return bannerservice.delete(ids);
    }

    @RequestMapping("updateStatus")
    @ResponseBody
    public int updateStatus(@Param("id")Integer id,@Param("status")Integer status){
        return bannerservice.update(id,status);
    }

    @RequestMapping("/selectKey")
    public Banners selectKey(@Param("id")Integer id){
        return bannerservice.selectByPrimaryKey(id);
    }

    @RequestMapping("update")
    @ResponseBody
    public int update(@RequestBody JSONObject json){
        Banners banners=new Banners();
        banners.setId(json.getInteger("id"));
        banners.setName(json.getString("name"));
        banners.setPictureUrl(json.getString("img"));
        banners.setUrlId(json.getInteger("url"));
        banners.setArticleId(json.getInteger("url"));
        banners.setStatus(json.getInteger("status"));
        return bannerservice.updateByPrimaryKey(banners);
    }
}
