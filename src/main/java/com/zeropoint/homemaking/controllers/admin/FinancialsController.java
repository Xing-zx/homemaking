package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Financial;
import com.zeropoint.homemaking.services.FinancialsService;
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
@RequestMapping("financial")
public class FinancialsController {

    @Autowired
    private FinancialsService financialService;

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> selectByCondition(@RequestParam("curr")Integer curr, @RequestParam("limit") Integer limit, @Param("name")String name, @Param("orderType")Integer orderType,
                                                @Param("startTime") String startTime, @Param("endTime") String endTime) {
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<Financial> adminlist=financialService.selectByCondition(page, limit, name, orderType, startTime, endTime);

        int count=financialService.count(name,orderType,endTime,startTime);
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
        return financialService.delete(ids);
    }

    @RequestMapping("selectKey")
    @ResponseBody
    public Financial selectKey(@Param("id") Integer id) {
        return financialService.selectKey(id);
    }
}
