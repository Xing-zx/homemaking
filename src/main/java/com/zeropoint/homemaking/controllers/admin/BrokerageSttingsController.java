package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.BrokerageSetting;
import com.zeropoint.homemaking.services.BrokerageSettingsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("brokerage")
public class BrokerageSttingsController {

    @Autowired
    private BrokerageSettingsService brokerageSettingService;

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> selectByCondition(@RequestParam("curr")Integer curr, @RequestParam("limit") Integer limit) {
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<BrokerageSetting> adminlist=brokerageSettingService.selectByCondition(page,limit);

        int count=brokerageSettingService.count();
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
    public int delete(@Param("ids")Integer[] ids) {
        return brokerageSettingService.delete(ids);
    }

    @RequestMapping("seleteKey")
    @ResponseBody
    public BrokerageSetting selectKey(@Param("id")Integer id) {
        return brokerageSettingService.selectKey(id);
    }

    @RequestMapping("update")
    @ResponseBody
    public int update(@Param("id")Integer id,@Param("status")Integer status) {
        return brokerageSettingService.update(id,status);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public int add(@RequestBody JSONObject jsonObject){
        BrokerageSetting brokerage=new BrokerageSetting();
        brokerage.setRole(jsonObject.getInteger("role"));
        brokerage.setLevel(jsonObject.getInteger("level"));
        brokerage.setStatus(jsonObject.getInteger("status"));
        brokerage.setProportion(jsonObject.getDouble("proportion"));
        System.out.println(brokerage);
        return brokerageSettingService.insert(brokerage);
    }
}
