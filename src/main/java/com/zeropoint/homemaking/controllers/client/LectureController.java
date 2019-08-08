package com.zeropoint.homemaking.controllers.client;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Lecture;
import com.zeropoint.homemaking.domain.User;
import com.zeropoint.homemaking.services.LectureService;
import com.zeropoint.homemaking.services.OrderService;
import com.zeropoint.homemaking.services.TokenService;
import com.zeropoint.homemaking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/api")
public class LectureController {

    @Autowired
    LectureService lectureService;

    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
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
    @RequestMapping("/lectureInfo")
    public JSONObject lectureInfo(@RequestBody JSONObject request){
        JSONObject res=new JSONObject();
        System.out.println(request.toJSONString());
        Lecture lecture =lectureService.findLectureById(request.getInteger("id"));
        Integer userId =request.getInteger("user_id");
        User user = userService.findUserById(userId);
        String token =request.getString("token");

        if( userId != null && token !="")
        {

            if (lecture != null && TokenService.authToken(token,user))
            {
                if(orderService.findLectureOrderByOrderIdAndId(request.getInteger("id"),userId)!=null)
                {
                    lecture.setErollStatus(1);
                }
                else {
                    lecture.setErollStatus(0);
                }
                res.put("code",1);
                res.put("msg","lectureInfo");
                res.put("data",lecture);
                return res;
            }
        }
        if(lecture!=null)
        {
            res.put("code",1);
            res.put("msg","lectureInfo");
            lecture.setErollStatus(2);
            res.put("data",lecture);
        }
        else {
            res.put("code",0);
            res.put("msg","线下课程不存在");
        }

        System.out.println(res.toJSONString());
        return res;

    }
}
