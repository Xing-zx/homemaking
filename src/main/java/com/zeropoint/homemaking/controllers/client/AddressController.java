package com.zeropoint.homemaking.controllers.client;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Address;
import com.zeropoint.homemaking.domain.User;
import com.zeropoint.homemaking.services.AddressService;
import com.zeropoint.homemaking.services.TokenService;
import com.zeropoint.homemaking.services.UserService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    AddressService addressService;
    @Autowired
    UserService userService;
    @RequestMapping("/addAddress")
    public JSONObject addAddress(@RequestBody JSONObject params){

        Address address =new Address();
        System.out.println(params.toJSONString());
        address.setProvince(params.getString("province"));
        address.setCity(params.getString("city"));
        address.setCounty(params.getString("county"));
        address.setDetail(params.getString("detail"));
        address.setUserId(params.getInteger("id"));
        JSONObject res=new JSONObject();
        Map<String,Integer> idMap= new HashMap<>(2);
        addressService.add(address);
        idMap.put("id",address.getId());
        res.put("data",idMap);
        res.put("code",1);
        res.put("msg","addAddress");
        return res;
    }

    @RequestMapping("/addressList")
    public JSONObject addressList(@RequestBody JSONObject request){
        Integer id =request.getInteger("id");
        JSONObject res = new JSONObject();
        res.put("code",1);
        res.put("msg","addressList");
        res.put("data",addressService.getList(id));
        System.out.println(res);
        return res;
    }
    @RequestMapping("/editAddress")
    public JSONObject editAddress(@RequestBody Address address){
        JSONObject res= new JSONObject();
        res.put("code",1);
        res.put("msg","editAddress");
        res.put("data",addressService.update(address));
        return res;
    }
    @RequestMapping("/deleteAddress")
    public JSONObject deleteAddress(@RequestBody JSONObject request){
        JSONObject res= new JSONObject();
         Integer id=request.getInteger("address_id");
         Integer userId= request.getInteger("id");
        User user= userService.findUserById(userId);
        if (TokenService.authToken(request.getString("token"), user)) {
           res.put("code",1);
           res.put("msg",addressService.delete(id));
           return res;
        }
        res.put("code",0);
        res.put("msg","删除失败");
        return res;
    }

}
