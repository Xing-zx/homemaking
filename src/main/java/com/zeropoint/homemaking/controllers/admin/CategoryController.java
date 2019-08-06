package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Category;
import com.zeropoint.homemaking.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @RequestMapping("/list")
    public Map<String,Object> selectPage(){
        List<Category> adminlist=categoryService.selectByCondition1();

        int count=categoryService.count1();
        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "数据返回成功");
        //将全部数据的条数作为count传给前台（一共多少条）
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", adminlist);
        //返回给前端

        String json= JSONObject.toJSONString(tableData);
        System.out.println(json);
        return tableData;
    }

    @RequestMapping("/insert")
    public int insert(@RequestBody JSONObject json){
        Category category=new Category();
        category.setName(json.getString("name"));
        category.setParent(json.getInteger("parent"));
        category.setStatus(json.getInteger("status"));
        return categoryService.insert(category);
    }

    @RequestMapping("/update")
    public int updateByPrimaryKey(@RequestBody JSONObject json){
        Category category=new Category();
        category.setId(json.getInteger("id"));
        category.setName(json.getString("name"));
        category.setParent(json.getInteger("parent"));
        category.setStatus(json.getInteger("status"));
        return categoryService.updateByPrimaryKey(category);
    }

    @RequestMapping("/updateStatus")
    public int updateByPrimaryKey(@RequestParam("id")Integer id,@RequestParam("status")Integer status){
        return categoryService.updateStatus1(id,status);
    }

    @RequestMapping("/selectTree")
    public  List<Category> selectTree(@RequestParam("parent")Integer parent){
        return categoryService.selectTree1(parent);
    }

    @RequestMapping("/delete")
    public int delete(@RequestParam("ids")Integer[] ids){
        return categoryService.delete1(ids);
    }
}
