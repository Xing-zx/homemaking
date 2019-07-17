package com.zeropoint.homemaking.controllers.client;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.services.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
public class LectureController {

    @Autowired
    LectureService lectureService;

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
}
