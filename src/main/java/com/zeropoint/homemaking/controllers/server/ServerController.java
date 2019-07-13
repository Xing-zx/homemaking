package com.zeropoint.homemaking.controllers.server;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.services.AdminService;
import com.zeropoint.homemaking.vo.Test;
import com.zeropoint.homemaking.vo.Test_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ServerController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/test")
    public JSONObject  test(@RequestBody JSONObject jsonObject){

        Test test=new Test();
        test.setCode(1);
        test.setMsg("success");

        Map<String,String> condition=new HashMap<>(16);
        condition.put("name","");
        condition.put("role","");
        condition.put("startTime","2019-6-11");
        condition.put("endTime","2019-8-11");
        test.setData(adminService.selectAll(condition).toArray());
        JSONObject result= new JSONObject();
        result.put("code",1);
        result.put("msg","success");
        result.put("data",adminService.selectAll(condition).toArray());
        return result;

    }

}
