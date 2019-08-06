package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Lecture;
import com.zeropoint.homemaking.services.LectureService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lecture")
public class LecturesController {

    @Autowired
    private LectureService lectureService;

    /** 管理员列表/查询
     * @return   the list
     */
    @RequestMapping("/list")
    public Map<String, Object> listLecture(@RequestParam("curr")Integer curr, @RequestParam("limit") Integer limit,
                                           @Param("name")String name, @Param("status")Integer status,
                                           @Param("endTime")String endTime, @Param("startTime")String startTime){
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<Lecture> adminlist=lectureService.selectByCondition1(page,limit,name,status,endTime,startTime);
        System.out.println(name+"----------------"+status+"------------------");
        int count=lectureService.count1(name,status,endTime,startTime);
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
    public int insertLecture(@RequestBody JSONObject conjson,Lecture lecture)throws Exception{
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");


        System.out.println(conjson.getString("endTime").replace(" ","")+"==================");

        Date activeEnd=formatter.parse(conjson.getString("endTime").replace(" ",""));
        Date activeStart=formatter.parse(conjson.getString("startTime").replace(" ",""));
        Date registerStart=formatter.parse(conjson.getString("startTime1").replace(" ",""));
        Date registerEnd=formatter.parse(conjson.getString("endTime1").replace(" ",""));

        lecture.setActiveEnd(activeEnd);
        lecture.setActiveStart(activeStart);
        lecture.setAmount(conjson.getDouble("amount"));
        lecture.setCourseSite(conjson.getString("courseSite"));
        lecture.setCreateTime(new Date());
        lecture.setCurrentCount(0);
        lecture.setDetail(conjson.getString("detail"));
        lecture.setMaxCount(conjson.getInteger("maxCount"));
        lecture.setName(conjson.getString("name"));
        lecture.setPictureUrl(conjson.getString("pictureUrl"));
        lecture.setRegisterEnd(registerEnd);
        lecture.setRegisterRule(conjson.getString("registerRule"));
        lecture.setRegisterStart(registerStart);
        lecture.setStatus(1);
        return lectureService.insert1(lecture);
    }

    @RequestMapping("/selectkey")
    @ResponseBody
    public Lecture selectKey(@RequestParam("id")Integer id){
        return lectureService.selectByPrimaryKey1(id);
    }

    @RequestMapping("update")
    @ResponseBody
    public int updateLecture(@RequestBody JSONObject conjson)throws Exception{
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");


        System.out.println(conjson.getString("endTime").replace(" ","")+"==================");

        Date activeEnd=formatter.parse(conjson.getString("endTime").replace(" ",""));
        Date activeStart=formatter.parse(conjson.getString("startTime").replace(" ",""));
        Date registerStart=formatter.parse(conjson.getString("startTime1").replace(" ",""));
        Date registerEnd=formatter.parse(conjson.getString("endTime1").replace(" ",""));
        Lecture lecture=new Lecture();
        lecture.setId(conjson.getInteger("id"));
        lecture.setActiveEnd(activeEnd);
        lecture.setActiveStart(activeStart);
        lecture.setAmount(conjson.getDouble("amount"));
        lecture.setCourseSite(conjson.getString("courseSite"));
        lecture.setCreateTime(conjson.getDate("createTime"));
        lecture.setCurrentCount(conjson.getInteger("count"));
        lecture.setDetail(conjson.getString("detail"));
        lecture.setMaxCount(conjson.getInteger("maxCount"));
        lecture.setName(conjson.getString("name"));
        lecture.setPictureUrl(conjson.getString("pictureUrl"));
        lecture.setRegisterEnd(registerEnd);
        lecture.setRegisterRule(conjson.getString("registerRule"));
        lecture.setRegisterStart(registerStart);
        lecture.setStatus(conjson.getInteger("status"));

        return lectureService.updateByPrimaryKey1(lecture);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int delete(@RequestParam("ids")Integer[] ids){
        return lectureService.delete1(ids);
    }

    @RequestMapping("/updatestatus")
    @ResponseBody
    public int updateStatus(@Param("id")Integer id,@Param("status")Integer status){
        return lectureService.updateStatus1(id,status);
    }
}
