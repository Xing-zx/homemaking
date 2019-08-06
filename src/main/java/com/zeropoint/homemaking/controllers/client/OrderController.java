package com.zeropoint.homemaking.controllers.client;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zeropoint.homemaking.domain.Lecture;
import com.zeropoint.homemaking.domain.LectureOrders;
import com.zeropoint.homemaking.domain.Order;
import com.zeropoint.homemaking.domain.User;
import com.zeropoint.homemaking.services.*;
import com.zeropoint.homemaking.vo.PersonnelOrder;
import com.zeropoint.homemaking.vo.UserOder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    LectureService lectureService;
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    PersonnelService personnelService;
    @RequestMapping("/lectureOrder")
    public JSONObject orderLecture(@RequestBody JSONObject request){
      JSONObject res = new JSONObject();
       Integer id= request.getInteger("id");
       String token =request.getString("token");
        try{
            User user =userService.findUserById(id);
            System.out.println(id);
            System.out.println(token);
            System.out.println(TokenService.getToken(user));
            if(!(TokenService.authToken(token,user)))
            {
                res.put("code",0);
                res.put("msg","token invaild");
                return res;
            }
            res.put("code",1);
            res.put("msg","orderlist");
            List<LectureOrders> list =orderService.findLectureOrderByUserId(id);
            for (int i=0; i< list.size(); i++)
            {   LectureOrders lectureOrders=list.get(i);
                Lecture lecture= lectureService.findLectureById(lectureOrders.getLectureId());
                list.get(i).setRegisterEnd(lecture.getRegisterEnd());
                list.get(i).setRegisterStart(lecture.getRegisterStart());
                list.get(i).setActiveStart(lecture.getActiveStart());
                list.get(i).setActiveEnd(lecture.getActiveEnd());
                list.get(i).setTitle(lecture.getName());
                list.get(i).setPictureUrl(lecture.getPictureUrl());
            }
            res.put("data",list);

        }catch (NullPointerException e)
        {
            e.printStackTrace();
            res.put("code",0);
            res.put("msg","无订单");

        }
       return res;
    }

    /**
     * @param request id,token,
     *
     * 	auntId:'',	//aunt_id阿姨id
     * 	name:'',	//预约人姓名
     * 	phone:'',	//预约人电话号码
     * 	addressId:'',	//预约人的地址id
     * 	workdate:'',	//工作日期
     * 	workStartTime:'',//工作开始时间 09:00
     * 	workEndTime:'',	//工作结束时间  14:00
     * 	requirement:[],	//预约人的要求 如果有三要求 就是三个长度的数组
     * 	remark:'',	//备注
     * @return
     */
    @RequestMapping("/userOrderList")
    JSONObject userOrderList(@RequestBody JSONObject request){
        System.out.println(request);
        JSONObject res =new JSONObject();
        String token =request.getString("token");
        Integer userId= request.getInteger("id");

            List<UserOder> orders=orderService.findOrderByUserId(userId);
            if(orders !=null) {
                res.put("code", 1);
                res.put("msg", "user orderList");
                res.put("data", orders);
            }
            else {
                res.put("code", 0);
                res.put("msg", "无订单");
            }
        System.out.println(res);
        return res;
    }
    @RequestMapping("/personnelOrderList")
    JSONObject personnelOrderList(@RequestBody JSONObject request){
        System.out.println(request);
        JSONObject res= new JSONObject();
        String token=request.getString("token");
        try
        {
            Integer personnelId= personnelService.findByUserId(request.getInteger("id")).getId();
            List<PersonnelOrder> orders=orderService.findPersonnelOrderByPersonnelId(personnelId);
            res.put("code",1);
            res.put("msg","personnel orderList");
            res.put("data",orders);

        }catch (NullPointerException e)
        {
            res.put("code",0);
            res.put("msg","无订单");

        }
        System.out.println(res);
        return res;
    }

    /**
     * id,token,
     * 	cancel_note,		//取消原因
     * 	order_number,		//单号
     * 	type,
     * @param request
     * @return
     */
    @RequestMapping("/cancelOrder")
    public JSONObject cancelOrder(@RequestBody JSONObject request){
        JSONObject res=new JSONObject();
        Integer id =request.getInteger("id");
        String token =request.getString("token");
        String orderNumber=request.getString("order_number");
        Integer type=request.getInteger("type");
        Order order=orderService.findOrderByOrderNumber(orderNumber);
        if (order.getStatus()>=3)
        {
            res.put("code",0);
            res.put("msg","无法取消");
            return res;
        }
        order.setStatus(-1);
        orderService.updateOrder(order);
        res.put("code",1);
        res.put("msg","取消成功");
        System.out.println(res);
        return res;
    }
    @RequestMapping("/orderInfo")
    public JSONObject orderInfo(@RequestBody JSONObject request){
        JSONObject res=new JSONObject();
        Integer orderId=request.getInteger("order_id");
        Integer userId=request.getInteger("id");
        String token=request.getString("token");
        Order order=orderService.findById(orderId);
        try{
            res.put("code",1);
            res.put("msg","orderInfo");
            res.put("data",order);

        }catch (NullPointerException e)
        {
            res.put("code",0);
            res.put("msg","该订单不存在");

        }
        System.out.println(res.toJSONString());
        return res;
    }

}
