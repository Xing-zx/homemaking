package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Category;
import com.zeropoint.homemaking.domain.UserPackage;
import com.zeropoint.homemaking.services.UserPackageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userpackage")
public class UserPackageController {

    @Autowired
    private UserPackageService userPackageService;

    @RequestMapping("/list")
    public Map<String,Object> selectByCondition1(@Param("userId")Integer userId){
        System.out.println(userId+"+++++++++++++++++++++++++");
        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "数据返回成功");
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", userPackageService.selectByCondition1(userId));
        return tableData;
    }
}
