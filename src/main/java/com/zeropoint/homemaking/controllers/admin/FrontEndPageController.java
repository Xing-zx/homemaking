package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chowhin
 */
@RestController
@RequestMapping("/admin/frontEndPage")
public class FrontEndPageController {


    @RequestMapping("/list")
    public JSONObject getFrontEndPageList()
    {
        JSONObject res=new JSONObject();
        res.put("data","");
        return res;
    }
}
