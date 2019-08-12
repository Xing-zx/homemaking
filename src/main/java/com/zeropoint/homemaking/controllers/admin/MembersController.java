package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.User;
import com.zeropoint.homemaking.services.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MembersController {

    @Autowired
    private UserService userservice;

    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> listAdmin(@RequestParam("curr")Integer curr, @RequestParam("limit") Integer limit,
                                @Param("name")String name,@Param("endTime")String endTime, @Param("startTime")String startTime){
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<User> userlist=userservice.UserSelect1(page,limit,name,endTime,startTime);

        int count=userservice.count1(name,endTime,startTime);
        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "数据返回成功");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", count);
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", userlist);
        //返回给前端

        String json=JSONObject.toJSONString(tableData);
        System.out.println(json);
        return tableData;
    }

    /** 删除/批量删除
     *
     * @return status
     */
    @RequestMapping ("/delete")
    @ResponseBody
    public void delete(@RequestParam(value="ids")Integer[] ids){
        System.out.println(ids+"------------------------------------");
        userservice.delete1(ids);
    }

    @RequestMapping("/selectkey")
    public User SelectKey(@Param("id")Integer id){
        return userservice.SelectKey1(id);
    }

    @RequestMapping("/updateBalance1")
    public int updateBalance1(@RequestBody JSONObject json) {
        return userservice.updateBalance1(json.getInteger("id"),json.getInteger("balance"));
    }

    @RequestMapping("/updateBrokerage1")
    public int updateBrokerage1(@RequestBody JSONObject json) {
        return userservice.updateBrokerage1(json.getInteger("id"), json.getDouble("brokerage"));
    }

    @RequestMapping("/updateBrokerage2")
    public int updateBrokerage2(@RequestBody JSONObject json) {
        return userservice.updateBrokerage2(json.getInteger("id"), json.getDouble("brokerage"));
    }

}
