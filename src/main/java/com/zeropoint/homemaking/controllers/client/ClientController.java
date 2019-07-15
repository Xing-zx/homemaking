package com.zeropoint.homemaking.controllers.client;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/home")
    public JSONObject getHome(){
         System.out.println("receive request");
        JSONObject res = new JSONObject();
        res.put("code",1);
        res.put("msg","success");
        Map< String ,Object> wrapper =new HashMap<>(16);
        wrapper.put("menu",homeService.getMenu());
        wrapper.put("swiper",homeService.getSwiper());
        res.put("data", wrapper);
        return  res;
    }


}
