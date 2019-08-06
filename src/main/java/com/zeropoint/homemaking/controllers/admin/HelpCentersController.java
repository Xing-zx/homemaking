package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.HelpCenter;
import com.zeropoint.homemaking.services.HelpCenterService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helpCenter")
public class HelpCentersController {

    @Autowired
    private HelpCenterService helpCenterService;


    @RequestMapping("update1")
    @ResponseBody
    public int update1(@RequestBody JSONObject jsonObject){
        HelpCenter help=new HelpCenter();
        help.setId(1);
        help.setText(jsonObject.getString("text"));
        return helpCenterService.update1(help);
    }

    @RequestMapping("select1")
    @ResponseBody
    public HelpCenter select1(@Param("id")Integer id){
        return helpCenterService.select1(id);
    }

    @RequestMapping("update2")
    @ResponseBody
    public int update2(@RequestBody JSONObject jsonObject){
        HelpCenter help=new HelpCenter();
        help.setId(3);
        help.setText(jsonObject.getString("text"));
        return helpCenterService.update2(help);
    }

    @RequestMapping("select2")
    @ResponseBody
    public HelpCenter select2(@Param("id")Integer id){
        return helpCenterService.select2(id);
    }

    @RequestMapping("update3")
    @ResponseBody
    public int update3(@RequestBody JSONObject jsonObject){
        HelpCenter help=new HelpCenter();
        help.setId(4);
        help.setText(jsonObject.getString("text"));
        return helpCenterService.update3(help);
    }

    @RequestMapping("select3")
    @ResponseBody
    public HelpCenter select3(@Param("id")Integer id){
        return helpCenterService.select3(id);
    }

}
