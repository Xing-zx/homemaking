package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Order;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.services.OrderService;
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
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    private OrderService orderservice;

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> selectAll(@Param("curr")Integer curr, @Param("limit")Integer limit, @Param("type")Integer type,
                                        @Param("name")String name, @Param("endTime")String endTime, @Param("startTime")String startTime){

        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<Order> list=orderservice.selectAll1(page,limit,type,name,endTime,startTime);

        int count=orderservice.count1(type,name,endTime,startTime);
        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "数据返回成功");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", count);
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", list);
        //返回给前端

        String json= JSONObject.toJSONString(tableData);
        System.out.println(json);
        return tableData;
    }

    @RequestMapping("listkey")
    @ResponseBody
    public Order selectKey(@RequestParam("id")Integer id){
        return orderservice.selectKey1(id);
    }

    @RequestMapping("personnelView")
    @ResponseBody
    public ServicePersonnel personnelView(@RequestParam("id")Integer id){
        System.out.println(id+"----------------------------------------------");
        return orderservice.personnelView1(id);
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(@RequestParam("ids")Integer[] ids){
        return orderservice.delete1(ids);
    }

    @RequestMapping("servicelist")
    @ResponseBody
    public Map<String,Object> SelectService(@Param("maxage")Integer maxage,@Param("minage")Integer minage,@Param("workType")Integer workType){
      /*  System.out.println(ids.toString()+"----------------------------");

        Integer[] id=new Integer[ids.length];*/
        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "数据返回成功");
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", orderservice.serviceSelect1(maxage, minage, workType));
        return tableData;

/*
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<ServicePersonnel> list=orderservice.serviceSelect1(page,limit,id);

        System.out.println(ids+"--------999999999 99999999999999");

        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "数据返回成功");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", list.size());
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", list);
        //返回给前端

        String json= JSONObject.toJSONString(tableData);
        System.out.println(json);
        return tableData;*/
    }

    @RequestMapping("selectOrder")
    @ResponseBody
    public Map<String,Object> SelectOrider(@Param("curr")Integer curr, @Param("limit")Integer limit, @Param("type")Integer type,
                                           @Param("name")String name,@Param("status")Integer status, @Param("endTime")String endTime, @Param("startTime")String startTime){
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<Order> list=orderservice.selectOrder1(page,limit,type,name,status,endTime,startTime);
        int count=orderservice.countOrder1(type,status,name,endTime,startTime);
        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "数据返回成功");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", count);
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", list);
        //返回给前端

        String json= JSONObject.toJSONString(tableData);
        System.out.println(json);
        return tableData;
    }
    @RequestMapping("/update3")
    public int updatemoneyTotal(@RequestParam("id") Integer id,@RequestParam("hetongImgsrc") String hetongImgsrc,
                                @RequestParam("moneyTotal") Double moneyTotal,@RequestParam("status")Integer status,
                                @Param("endTime")String endTime, @Param("startTime")String startTime,@RequestParam("assignIds")String assignIds,
                                @Param("moneyBargin")Double moneyBargin,@Param("moneyAdvance")Double moneyAdvance,@Param("moneyFinal")Double moneyFinal,
                                @Param("moneyActual")Double moneyActual){
        return orderservice.updatemoneyTotal(id, hetongImgsrc, moneyTotal,status,endTime,startTime,assignIds,moneyBargin,moneyAdvance,moneyFinal,moneyActual);
    }


    @RequestMapping("commsionSelect")
    public Map<String,Object> commsionSelect(@Param("curr")Integer curr, @Param("limit")Integer limit){

        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<Order> list=orderservice.commsionSelect(page,limit);

        int count=orderservice.commsionCount();
        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "数据返回成功");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", count);
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", list);
        //返回给前端

        String json= JSONObject.toJSONString(tableData);
        System.out.println(json);
        return tableData;
    }


    @RequestMapping("/updatecomm")
    public int updatecomm(@RequestParam("id")Integer id,@RequestParam("commsionStatus")Integer commsionStatus) {
        return orderservice.updatecomm(id, commsionStatus);
    }
}
