package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Broker;
import com.zeropoint.homemaking.domain.Stores;
import com.zeropoint.homemaking.services.StoresdService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("stores")
public class StoresaController {

    @Autowired
    private StoresdService storesService;

    @RequestMapping("insert")
    @ResponseBody
    public int insert(@RequestBody JSONObject json) {
        Stores stores=new Stores();
        stores.setStoresId(json.getInteger("storesId"));
        stores.setStoresAddress(json.getString("address"));
        stores.setStoresIntroduced(json.getString("phone"));
        stores.setStoresName(json.getString("name"));
        stores.setStoresPassword(json.getString("password"));
        stores.setCreatTime(new Date());
        stores.setSionsId(3);
        stores.setBrokerId(json.getInteger("broker"));
        return storesService.insert(stores);
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> selectByCondition(@RequestParam("curr")Integer curr, @RequestParam("limit") Integer limit,
                                          @Param("name")String name,@Param("endTime")String endTime, @Param("startTime")String startTime) {
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<Stores> storeslist=storesService.selectByCondition(page,limit,name,endTime,startTime);

        int count=storesService.count(name,endTime,startTime);
        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "数据返回成功");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", count);
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", storeslist);
        //返回给前端

        String json=JSONObject.toJSONString(tableData);
        System.out.println(json);
        return tableData;
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(@RequestParam("ids")Integer[] ids) {
        return storesService.delete(ids);
    }

    @RequestMapping("selectKey")
    @ResponseBody
    public Stores SelectAll(@RequestParam(value = "storesId")Integer storesId) {
        return storesService.SelectAll(storesId);
    }

    @RequestMapping("updateAll")
    @ResponseBody
    public int updateAll(@RequestBody JSONObject json) {
        System.out.println(json.getInteger("id")+"-------------------------------------");
        Stores stores=new Stores();
        stores.setStoresId(json.getInteger("id"));
        stores.setStoresAddress(json.getString("address"));
        stores.setStoresIntroduced(json.getString("phone"));
        stores.setStoresName(json.getString("name"));
        stores.setStoresPassword(json.getString("password"));
        stores.setSionsId(3);
        stores.setCreatTime(json.getDate("time"));
        stores.setBrokerId(json.getInteger("broker"));
        stores.setStatus(json.getInteger("status"));
        return storesService.updateAll(stores);
    }

    @RequestMapping("updateStatus")
    @ResponseBody
    public int updateStatus(@Param("storesId")Integer storesId,@Param("status")Integer status) {
        return storesService.updateStatus(storesId,status);
    }

    /** 获取下拉框
     * @return   the list
     */
    @RequestMapping("/selectbroker")
    @ResponseBody
    public List<Broker> selectStores(){
        System.out.println("进入--------*******************");
        return storesService.selectBroker();
    }
}
