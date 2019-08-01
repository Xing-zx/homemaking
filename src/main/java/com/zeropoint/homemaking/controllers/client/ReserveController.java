package com.zeropoint.homemaking.controllers.client;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.zeropoint.homemaking.domain.*;
import com.zeropoint.homemaking.services.OrderService;
import com.zeropoint.homemaking.services.PayService;
import com.zeropoint.homemaking.services.PersonnelService;
import com.zeropoint.homemaking.utils.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author chowhin
 */
@RestController
@RequestMapping("/reserve")
public class ReserveController {

    @Autowired
    private PayService payService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PersonnelService personnelService;
    /**
     * id,token,
     * 	type,		//预约人需要的服务 1月嫂 2保姆 3钟点工
     * 	name,		//预约人姓名
     * 	phone,		//预约人的手机号码
     * 	appointDate,	//预约日期
     * 	appointTime,	//预约时间
     * 	addressId,	//预约人的地址id
     * 	ageMin，	//预约人要求最阿姨最小年龄
     * 	ageMax,		//预约人要求阿姨最大年龄
     * 	expirence,	//预约人要求阿姨工作经验
     * 	address,	//预约人要求阿姨籍贯
     * 	requirement:[],	//预约人的要求 如果有三要求 就是三个长度的数组
     * 	remark:'',	//备注
     */
    @RequestMapping("/personnel")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public JSONObject reservePersonnel(@RequestBody JSONObject request){
        JSONObject res= new JSONObject();
        System.out.println(request.toJSONString());
        Integer id =request.getInteger("userId");
        String token =request.getString("token");
        Integer type=request.getInteger("type");
        String name=request.getString("name");
        String phone =request.getString("phone");
        Integer addressId=request.getInteger("addressId");
        String date = request.getString("appointDate");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date appointDate= null;
        try {
            appointDate = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String requireAge=request.getString("age");
        String [] requirements=request.getObject("requirement",String[].class);
        String requirement=ConvertUtil.requirementConvert(requirements);
       try{
            Order order =new Order();
            order.setRequirement(requirement);
            order.setUserId(id);
            order.setType(type);
            order.setOrderNumber(OrderService.generateOrderNumber(id.toString(),type.toString()));
            order.setStatus(1);
            order.setRequireAge(requireAge);
            order.setUserName(name);
            order.setUserPhone(phone);
            order.setAddressId(addressId);
            order.setAppiontDate(appointDate);
            order.setCreateTime(new Date());
            orderService.addOrder(order);
            res.put("code",1);
            res.put("msg","reserve success");

       }catch (NullPointerException e){
           e.printStackTrace();
           res.put("code",0);
           res.put("msg","fail");
       }
        return res;
    }
    @RequestMapping("/personnelList")
    public JSONObject reserveList(@RequestBody JSONObject request){
        JSONObject res=new JSONObject();
        System.out.println(request.toJSONString());
        Integer userId =request.getInteger("id");
        Integer id=request.getInteger("order_id");
        String token =request.getString("token");
        Order order=orderService.findById(id);
       try {
           String[] ids = order.getAssignIds().split(",");
           List<ServicePersonnel> servicePersonnels = personnelService.findPersonnelByids(ids);
           if(servicePersonnels!=null) {
               for (ServicePersonnel personnel : servicePersonnels) {
                   List<Speciality> specialitys = personnelService.getSpeciality(personnel.getId());
                   if (specialitys != null) {
                       List<Integer> list = new ArrayList<>();
                       for (Speciality speciality : specialitys) {
                           list.add(speciality.getCategoryId());
                       }
                       personnel.setSpecialities(list);
                   }
                   List<Certificate> certificates = personnelService.getCertificate(personnel.getId());
                   if (certificates != null) {
                       List<Integer> list = new ArrayList<>();
                       for (Certificate certificate : certificates) {
                           list.add(certificate.getCategoryId());
                       }
                       personnel.setCertificates(list);
                   }

               }
           }

           res.put("code", 1);
           res.put("msg", "the list of personnel to be selected");
           res.put("data", servicePersonnels);
       }catch (NullPointerException e)
       {
           e.printStackTrace();
           res.put("code",0);
           res.put("msg","");
       }
        System.out.println(res);
        return res;
    }


}
