package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.domain.Stores;
import com.zeropoint.homemaking.services.PersonnelService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/servicepe")
public class ServicePersonnelsController {

    @Autowired
    private PersonnelService personnel;


    /** 列表/查询
     * @return   the list
     */
    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> listService(@RequestParam("curr")Integer curr, @RequestParam("limit") Integer limit,
                                              @Param("name")String name, @Param("storesId")Integer storesId, @Param("workType")Integer workType,
                                              @Param("endTime")String endTime, @Param("startTime")String startTime){
        System.out.println(name+"----------------------"+storesId+"----------------"+endTime+"---------------"+startTime);
        int page=(curr-1)*limit;

        List<ServicePersonnel> personnellist=personnel.selectByCondition1(page,limit,name,storesId,workType,endTime,startTime);

        int count=personnel.count1(name,storesId,workType,startTime,endTime);
        Map<String,Object> PersonnellData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        PersonnellData.put("code", 0);
        PersonnellData.put("msg", "数据返回成功");
        //将全部数据的条数作为count传给前台（一共多少条）
        PersonnellData.put("count", count);
        //将分页后的数据返回（每页要显示的数据）
        PersonnellData.put("data", personnellist);
        //返回给前端

        String json=JSONObject.toJSONString(PersonnellData);
        System.out.println(json);
        return PersonnellData;
    }

    /** 未审核列表/查询
     * @return   the list
     */
    @RequestMapping("/lists")
    @ResponseBody
    public Map<String,Object> listServices(@RequestParam("curr")Integer curr, @RequestParam("limit") Integer limit,
                                               @Param("name")String name,@Param("workType")Integer workType,
                                               @Param("endTime")String endTime, @Param("startTime")String startTime){
        System.out.println(name+"----------------------------------"+endTime+"---------------"+startTime);
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<ServicePersonnel> personnellist=personnel.selectByConditions1(page,limit,name,workType,startTime,endTime);

        int count=personnel.counts1(name,workType,startTime,endTime);
        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "数据返回成功");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", count);
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", personnellist);
        //返回给前端

        String json=JSONObject.toJSONString(tableData);
        System.out.println(json);
        return tableData;
    }


    /** 单个查询
     * @return   the list
     */
    @RequestMapping("/selectid")
    public ServicePersonnel selectID(@RequestParam(value = "id")Integer id){
        System.out.println(id+"-----------------------------");
        return personnel.SelectIds1(id);
    }

    /** 获取下拉框
     * @return   the list
     */
    @RequestMapping("/selectstores")
    @ResponseBody
    public List<Stores> selectStores(){
        System.out.println("进入--------*******************");
        return personnel.selectStores1();
    }

    /** 删除/批量删除
     *
     * @return status
     */
    @RequestMapping ("/delete")
    @ResponseBody
    public void delete(@RequestParam(value="ids")Integer[] ids){
        System.out.println(ids+"------------------------------------");
        personnel.delete1(ids);
    }
}

