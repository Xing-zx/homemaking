package com.zeropoint.homemaking.controllers.client;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Income;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.domain.Withdraw;
import com.zeropoint.homemaking.services.BillService;
import com.zeropoint.homemaking.services.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.jar.JarEntry;

/**
 * @author chowhin
 */
@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    PersonnelService personnelService;
    @Autowired
    BillService billService;
    @RequestMapping("/personnelIncomeList")
    public JSONObject personnelBill(@RequestBody JSONObject request){
        JSONObject res =new JSONObject();
        System.out.println(request.toJSONString());
        Integer id=request.getInteger("id");
        String token=request.getString("token");
        String date=request.getString("date")+"-0";
        ServicePersonnel personnel =personnelService.findByUserId(id);
        Double balance=personnel.getBalance();
        List<Income> list=billService.findByPersonnelIdAndDate(personnel.getId(),date);
        Double input=billService.getInput(date,personnel.getId());
        Double output=billService.getOutput(date,personnel.getId());
        JSONObject data= new JSONObject();
        data.put("output",output);
        data.put("input",input);
        data.put("balance",balance);
        data.put("data",list);
        res.put("code",1);
        res.put("msg","income list");
        res.put("data",data);
        System.out.println(res);
        return res;
    }

    /**
     * id,token,
     * 	money,		//金额
     * 	alipayAccount,	//支付宝账号
     * 	name		//姓名
     * 	type:2,		//1 佣金提现 2服务费提现
     *
     * @param request
     * @return
     */
    @RequestMapping("/personnelSubmitWithdraw")
    public JSONObject submitWithdraw(@RequestBody JSONObject request){
        JSONObject res=new JSONObject();
        Integer id= request.getInteger("id");
        String token =request.getString("token");
        Double money =request.getDouble("money");
        String alipayAccount =request.getString("alipayAccount");
        String name=request.getString("name");
        Integer type=request.getInteger("type");
        ServicePersonnel personnel =personnelService.findByUserId(id);
        if(money > personnel.getBalance())
        {
            res.put("code",0);
            res.put("msg","余额不足");
            return res;
        }
        Withdraw withdraw =new Withdraw();
        withdraw.setAlipayAccount(alipayAccount);
        withdraw.setCreateTime(new Date());
        withdraw.setName(name);
        withdraw.setUserId(id);
        withdraw.setMoney(money);
        withdraw.setType(type);
        billService.addWithdraw(withdraw);
        personnel.setBalance(personnel.getBalance()-money);
        res.put("code",1);
        res.put("msg","提交提现请求成功");
        System.out.println(res);
        return res;
    }


}
