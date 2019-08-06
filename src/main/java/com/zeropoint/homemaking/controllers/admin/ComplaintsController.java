package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Complaint;
import com.zeropoint.homemaking.services.ComplaintService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/complaint")
public class ComplaintsController {

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping("list")
    public Map<String ,Object> selectPage(@RequestParam("curr")Integer curr, @RequestParam("limit") Integer limit){
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<Complaint> adminlist=complaintService.selectPage1(page,limit);

        int count=complaintService.count1();
        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "数据返回成功");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", count);
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", adminlist);
        //返回给前端

        String json= JSONObject.toJSONString(tableData);
        System.out.println(json);
        return tableData;
    }

    @RequestMapping("/delete1")
    public int delete1(@Param("ids")Integer[] ids){
        return complaintService.delete1(ids);
    }
}
