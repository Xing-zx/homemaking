package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.BrokerageSetting;
import com.zeropoint.homemaking.domain.Withdraw;
import com.zeropoint.homemaking.services.WithdrawsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("withdraw")
public class WithdrawsController {

    @Autowired
    private WithdrawsService withdrawService;


    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> selectByCondition(@RequestParam("curr")Integer curr, @RequestParam("limit") Integer limit,
                                                 @Param("name")String name, @Param("endTime")String endTime, @Param("startTime")String startTime) {
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<Withdraw> adminlist=withdrawService.selectPage(page,limit,name,endTime,startTime);

        int count=withdrawService.count(name,endTime,startTime);
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

    @RequestMapping("update")
    @ResponseBody
    public int update(@RequestParam("id") Integer id,@RequestParam("status") Integer status) {
        return withdrawService.update(id,status);
    }

/*    @RequestMapping("delete")
    @ResponseBody
    public int delete(Integer[] ids) {
        return withdrawService.delete(ids);
    }*/


    @RequestMapping("selectfee")
    @ResponseBody
    public BrokerageSetting selectfee() {
        return withdrawService.selectfee();
    }

    @RequestMapping("update1")
    public int update2(@RequestBody JSONObject json) {
        return withdrawService.update2(json.getInteger("id"), json.getDouble("fee"), json.getDouble("finalMoney"));
    }

    @RequestMapping("delete")
    public int delete1(Integer[] ids) {
        return withdrawService.delete1(ids);
    }

}
