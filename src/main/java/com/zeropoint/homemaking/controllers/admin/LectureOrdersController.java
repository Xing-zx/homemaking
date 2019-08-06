package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.LectureOrders;
import com.zeropoint.homemaking.services.LectureOrdersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("lectureOrder")
public class LectureOrdersController {

    @Autowired
    private LectureOrdersService lectureOrderService;

    @RequestMapping("insert")
    @ResponseBody
    public int insert(JSONObject json) {
        LectureOrders order=new LectureOrders();
        order.setAmount(json.getDouble("amount"));
        order.setCreateTime(json.getDate("createTime"));
        order.setLectureId(json.getInteger("lectureId"));
        order.setOrderNumber(json.getString("orderNumber"));
        order.setPayTime(json.getDate("payTime"));
        order.setPrepayId(json.getString("prepayId"));
        order.setStatus(json.getInteger("status"));
        order.setUserId(json.getInteger("userId"));
        return lectureOrderService.insert(order);
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> selectByCondition(@RequestParam("curr")Integer curr, @RequestParam("limit") Integer limit,
                                                 @Param("name")String name, @Param("status")Integer status,
                                                 @Param("endTime")String endTime, @Param("startTime")String startTime) {
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<LectureOrders> adminlist=lectureOrderService.selectByCondition(page,limit,name,status,endTime,startTime);

        int count=lectureOrderService.count(name,status,endTime,startTime);
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
    public int delete(@Param("ids") Integer[] ids) {
        return lectureOrderService.delete(ids);
    }

    @RequestMapping("selectKey")
    @ResponseBody
    public LectureOrders selectKey(@Param("id")Integer id) {
        return lectureOrderService.selectKey(id);
    }
}
