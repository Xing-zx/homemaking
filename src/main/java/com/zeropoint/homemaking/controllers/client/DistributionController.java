package com.zeropoint.homemaking.controllers.client;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.services.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chowhin
 */
@RestController
@RequestMapping("/distribute")
public class DistributionController {
    @Autowired
    PersonnelService personnelService;
    @RequestMapping("/detail")
    public JSONObject distributeDetail(@RequestBody JSONObject request){
        JSONObject res =new JSONObject();
        Integer userId=request.getInteger("id");
        ServicePersonnel personnel=personnelService.findByUserId(userId);
        JSONObject data=new JSONObject();
        data.put("allIncome",personnel.getAllBrokerage());
        data.put("withdraw",personnel.getWithdrawalBrokerage());
        int count =personnelService.getPersonCount(personnel.getId());
        data.put("person",count);
        res.put("code",1);
        res.put("msg","distributionDetail");
        res.put("data",data);
        System.out.println(res);
        return res;
    }
}
