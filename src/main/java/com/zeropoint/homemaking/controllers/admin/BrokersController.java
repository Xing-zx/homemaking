package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Broker;
import com.zeropoint.homemaking.services.BrokersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("broker")
public class BrokersController {

    @Autowired
    private BrokersService brokerService;

    @RequestMapping("insert")
    @ResponseBody
    public int insert(@RequestBody JSONObject json) {
        Broker broker=new Broker();
        broker.setName(json.getString("name"));
        broker.setPassword(json.getString("password"));
        broker.setPhone(json.getString("phone"));
        broker.setStatus(json.getInteger("status"));
        broker.setTexts(json.getString("content"));
        broker.setAddress(json.getString("address"));
        broker.setTime(new Date());
        return brokerService.insert(broker);
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> selectByCondition(@RequestParam("curr")Integer curr, @RequestParam("limit") Integer limit,@Param("name")String name,
                                          @Param("endTime")String endTime, @Param("startTime")String startTime) {
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<Broker> adminlist=brokerService.selectByCondition(page,limit,name,endTime,startTime);

        int count=brokerService.count(name,endTime,startTime);
        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "数据返回成功");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", count);
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", adminlist);
        //返回给前端

        String json=JSONObject.toJSONString(tableData);
        System.out.println(json);
        return tableData;
    }

    @RequestMapping("delete")
    @ResponseBody
    public void delete(@RequestParam("ids") Integer[] ids) {
        brokerService.delete(ids);
    }

    @RequestMapping("updateStatus")
    @ResponseBody
    public int updateStatus(Integer id, Integer status) {
        return brokerService.updateStatus(id,status);
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public Broker SelectKey(@RequestParam("id") Integer id) {
        return brokerService.SelectKey(id);
    }

    @RequestMapping("updateAll")
    @ResponseBody
    public int updateAll(@RequestBody JSONObject json) {
        Broker broker=new Broker();
        broker.setId(json.getInteger("id"));
        broker.setName(json.getString("name"));
        broker.setPassword(json.getString("password"));
        broker.setPhone(json.getString("phone"));
        broker.setStatus(json.getInteger("status"));
        broker.setTexts(json.getString("content"));
        broker.setAddress(json.getString("address"));
        broker.setTime(json.getDate("time"));
        return brokerService.updateAll(broker);
    }

}
