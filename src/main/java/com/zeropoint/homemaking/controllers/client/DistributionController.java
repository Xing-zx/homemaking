package com.zeropoint.homemaking.controllers.client;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chowhin
 */
@RestController
@RequestMapping("/distribute")
public class DistributionController {
    @RequestMapping("/personnel")
    public JSONObject distributeDetail(@RequestBody JSONObject request){
        JSONObject res =new JSONObject();
        res.put("code",1);
        res.put("msg","distributionDetail");
        return res;
    }
}
