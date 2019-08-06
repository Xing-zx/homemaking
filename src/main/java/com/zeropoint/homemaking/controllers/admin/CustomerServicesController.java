package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.CustomerService;
import com.zeropoint.homemaking.services.CustomersServices;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerServicesController {

    @Autowired
    private CustomersServices customerServices;

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> SelectAll(@RequestParam("curr")Integer curr, @RequestParam("limit") Integer limit){
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<CustomerService> adminlist=customerServices.selectAll(page,limit);

        int count=customerServices.count();
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

    @RequestMapping("insert")
    @ResponseBody
    public int insert(@RequestBody JSONObject json){
        CustomerService customer=new CustomerService();
        customer.setName(json.getString("name"));
        customer.setPhone(json.getString("phone"));
        customer.setStatus(json.getInteger("status"));
        return customerServices.insert(customer);
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(@Param("ids")Integer[] ids){
        return customerServices.delete(ids);
    }

    @RequestMapping("update")
    @ResponseBody
    public int update(@Param("id")Integer id,@Param("status")Integer status){
        return customerServices.update(id,status);
    }
}
