package com.zeropoint.homemaking.controllers.client;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.services.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@RestController
public class PersonnelController {

    @Autowired
    PersonnelService personnelService;

    /**  阿姨列表
     * @param cond  城市
     * @return 阿姨列表
     */
    @RequestMapping("/personnelList")
    public JSONObject getList(@RequestBody Map<String,Object> cond){
        JSONObject res=new JSONObject();
        res.put("code",1);
        res.put("msg","list");
        System.out.println(cond.toString());
        res.put("data",personnelService.getList(cond));
        return res;
    }

    /**
     *  筛选阿姨
     * @param cond 筛选条件
     * @return 阿姨列表
     */
    @RequestMapping("/filterPersonnel")
    public JSONObject query(@RequestBody Map<String,Object> cond){
        int pageCount=(int)cond.get("pagination");
        PageHelper.startPage(pageCount,8);
        PageInfo<ServicePersonnel> personnelPageInfo = new PageInfo<>(personnelService.getList(cond));
        JSONObject res=new JSONObject();
        if(personnelPageInfo.getSize() >=pageCount )
        {
            res.put("code", 1);
            res.put("msg", "filter");
            System.out.println(cond.toString());
            List<ServicePersonnel> list = personnelPageInfo.getList();
            res.put("data", list);
            System.out.println(list.size());
        }
        else{
            res.put("code",1);
            res.put("msg","there are not more thing");
            res.put("data",null);
        }
        System.out.println(res.toJSONString());
        return res;
    }
    @RequestMapping("/personnelInfo")
    public JSONObject personnelInfo(@RequestBody JSONObject request){
        return null;
    }

}
