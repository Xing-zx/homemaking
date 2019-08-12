package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Faq;
import com.zeropoint.homemaking.services.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/faq")
public class FaqController {

    @Autowired
    private FaqService faqService;

    @RequestMapping("/list")
    public Map<String , Object> selectPage1(@RequestParam("curr")Integer curr, @RequestParam("limit") Integer limit){
        System.out.println(limit);
        int page=(curr-1)*limit;
        System.out.println(page);
        List<Faq> adminlist=faqService.selectPage1(page,limit);

        int count=faqService.count();
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

    @RequestMapping("/delete")
    public int deleteByPrimaryKey(@RequestParam("id")Integer[] id) {
        return faqService.deleteByPrimaryKey(id);
    }

    @RequestMapping("/insert")
    public int insert(@RequestBody JSONObject json) {
        Faq faq=new Faq();
        faq.setAnswer(json.getString("answer"));
        faq.setQuestion(json.getString("question"));
        return faqService.insert(faq);
    }

    @RequestMapping("/selectKey")
    public Faq selectByPrimaryKey(@RequestParam("id") Integer id) {
        return faqService.selectByPrimaryKey(id);
    }

    @RequestMapping("/update")
    public int updateByPrimaryKey(@RequestBody JSONObject json) {
        Faq faq=new Faq();
        faq.setId(json.getInteger("id"));
        faq.setAnswer(json.getString("answer"));
        faq.setQuestion(json.getString("question"));
        return faqService.updateByPrimaryKey(faq);
    }

}
