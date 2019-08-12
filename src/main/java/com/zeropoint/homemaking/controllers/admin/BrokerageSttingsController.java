package com.zeropoint.homemaking.controllers.admin;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.zeropoint.homemaking.domain.BrokerageSetting;
import com.zeropoint.homemaking.services.BrokerageSettingsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public List<BrokerageSetting> selectByCondition(){
        return brokerageSettingService.selectBrokerageSetting();
    }

    @RequestMapping("update")
    public int updatePro(@RequestBody JSONObject json, HttpServletRequest request) {
        Double usera=json.getDouble("yi");
        Double userb=json.getDouble("er");
        Double fee=json.getDouble("fee");
        Double balance=json.getDouble("balance");
        System.out.println(usera+"------------"+userb+"=============="+fee+"-----------------"+balance);
        return brokerageSettingService.updatePro(usera,userb,fee,balance);
    }

}
