package com.zeropoint.homemaking.controllers.client;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.utils.StringUtils;
import com.zeropoint.homemaking.domain.*;
import com.zeropoint.homemaking.services.*;
import com.zeropoint.homemaking.utils.ConvertUtil;
import com.zeropoint.homemaking.vo.PayOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/api/pay")
public class PayController {

    @Autowired
    PayService payService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    LectureService lectureService;
    @Autowired
    PersonnelService personnelService;
    @Autowired
    BillService billService;

    @RequestMapping(value = "/lecture", method = RequestMethod.POST)
    public JSONObject lecturePay(@RequestBody JSONObject request,HttpServletRequest requestHeader) {
        JSONObject res= new JSONObject();
        try {
            User user=userService.findUserById(request.getInteger("id"));
            String openId=user.getOpenId();
            String spbill_create_ip = getIpAddr(requestHeader);
            String msg=orderService.lectureOrderCheck(request.getInteger("course_id"),request.getInteger("id"));
            if(!("ok".equals(msg))&&!("goTopay".equals(msg)))
            {
                res.put("code",0);
                res.put("msg",msg);
                return res;
            }
            LectureOrders order;
            if ("goTopay".equals(msg)) {
                order = orderService.findLectureOrderByOrderIdAndId(request.getInteger("course_id"), request.getInteger("id"));
            } else {
                order = orderService.generateLectureOrder(request.getInteger("course_id"), request.getInteger("id"));
            }
            PayOrder payOrder=new PayOrder(order);
            payOrder.setGoodName(" 线下课程");
            payOrder.setAmount(order.getAmount());
            JSONObject result = payService.wxPay(spbill_create_ip, openId, payOrder);
            res.put("code", 1);
            res.put("msg", "pay submit");
            res.put("data", result);
        } catch (NullPointerException e) {
            e.printStackTrace();
            res.put("code",0);
            res.put("msg", "pay fail");
        } catch (Exception e)
        {
            e.printStackTrace();
            res.put("code",0);
            res.put("msg", "pay fail");
        }
        System.out.println(res.toJSONString());
        return res;
    }

    /**
     *
     * @param request
     * @param requestHeader
     *
     *  id,token,
     * 	auntId:'',		//aunt_id阿姨id
     * 	name:'',		//预约人姓名
     * 	phone:'',		//预约人电话号码
     * 	addressId:'',	//预约人的地址id
     * 	workdate:'',	//工作日期
     * 	workStartTime:'',	//工作开始时间 09:00
     * 	workEndTime:'',	//工作结束时间  14:00
     * 	requirement:[],	//预约人的要求 如果有三要求 就是三个长度的数组
     * 	remark:'',		//备注
     * @return
     */
    @RequestMapping("/hourlyWorker")
    public JSONObject hourlyWorkerPay(@RequestBody JSONObject request,HttpServletRequest requestHeader){
        JSONObject res = new JSONObject();
        System.out.println(request);
        Integer id =request.getInteger("id");
        String token =request.getString("token");
        Integer personnelId=request.getInteger("auntId");
        String name=request.getString("name");
        String phone =request.getString("phone");
        Integer addressId=request.getInteger("addressId");
        String workdate=request.getString("workdate");
        String workStartTime=request.getString("workStartTime");
        String workEndTime =request.getString("workEndTime");
        String [] requirements=request.getObject("requirement",String[].class);
        System.out.println(requirements[0]);
        String remark=request.getString("remark");

        try
        {
            Date workStart=ConvertUtil.workdateConvert(workdate,workStartTime);
            Date workEnd=ConvertUtil.workdateConvert(workdate,workEndTime);
            String resultStr=orderService.orderCheck(personnelId,workStart,workEnd);
            if(!"ok".equals(resultStr))
            {
                res.put("code",0);
                res.put("msg",resultStr);
                return res;
            }
            Order order =new Order();
            User user=userService.findUserById(request.getInteger("id"));
            String openId=user.getOpenId();
            String spbill_create_ip = getIpAddr(requestHeader);
            order.setUserId(id);
            order.setPersonnelId(personnelId);
            order.setUserName(name);
            order.setAddressId(addressId);
            order.setRemark(remark);

            System.out.println(orderService.orderCheck(personnelId,workStart,workEnd));
            long from2 = workStart.getTime();
            long to2 = workEnd.getTime();
            int hours = (int) ((to2 - from2) / (1000 * 60 * 60));
            System.out.println("两个时间之间的小时差为：" + hours);
            order.setOrderNumber(OrderService.generateOrderNumber(id.toString(),"3"));
            order.setRequirement(ConvertUtil.requirementConvert(requirements));
            order.setWorkStartTime(workStart);
            order.setWorkEndTime(workEnd);
            order.setType(3);
            order.setCreateTime(new Date());
            order.setStatus(2);
            order.setUserPhone(phone);
            ServicePersonnel personnel=personnelService.findById(personnelId);
            order.setMoneyTotal(personnel.getChargeStandard()*(double)hours);
            order.setTitle("测试");
            order.setMoneyHour(personnel.getChargeStandard());
            orderService.addOrder(order);
            PayOrder payOrder=new PayOrder(order);
            payOrder.setGoodName("钟点工");
            payOrder.setAmount(order.getMoneyTotal());
            JSONObject result = payService.wxPay(spbill_create_ip, openId, payOrder);
            System.out.println(result);
            res.put("code", 1);
            res.put("msg", "pay hourly");
            res.put("data", result);
        }catch (NullPointerException e){
            e.printStackTrace();
            res.put("code", 0);
            res.put("msg", "fail");
        }catch (Exception e)
        {
            e.printStackTrace();
            res.put("code", 0);
            res.put("msg", "fail");

        }
        System.out.println(res);
        return res;
    }

    /**
     *
     * @param request id,token,order_id,aunt_id
     * @return
     * //1待签约 2待服务 (3待付定金 4待付预付款 5待付尾款)==服务中 6完成 -1取消
     */
    @RequestMapping("/personnel")
    public  JSONObject payPersonnel(@RequestBody JSONObject request,HttpServletRequest requestHeader)
    {
        JSONObject res= new JSONObject();
        Integer userId= request.getInteger("id");
        String token =request.getString("token");
        Integer personnelId=request.getInteger("aunt_id");
        Integer orderId= request.getInteger("order_id");
       try {
           User user = userService.findUserById(request.getInteger("id"));
           String openId = user.getOpenId();
           String spbill_create_ip = getIpAddr(requestHeader);
           Order order = orderService.findById(orderId);
           Integer type=order.getType();
           order.setOrderNumber(OrderService.generateOrderNumber(userId.toString(),type.toString()));
           PayOrder payOrder = new PayOrder(order);
           Integer status =order.getStatus();
          if(status<3) {
              if (type == 1) {
                  status = 3;
              }
              if (type == 2) {
                  status = 4;
              }
          }
           switch (status) {
               case 3:
                   payOrder.setAmount(order.getMoneyBargin());
                   payOrder.setGoodName("定金");
                   break;
               case 4:
                   payOrder.setAmount(order.getMoneyAdvance());
                   payOrder.setGoodName("预付款");
                   break;
               case 5:
                   payOrder.setAmount(order.getMoneyFinal());
                   payOrder.setGoodName("尾款");
                   break;
               case 2:
                   payOrder.setAmount(order.getMoneyTotal());
                   payOrder.setGoodName("钟点工");
                   break;
               default:
                   res.put("code", 0);
                   res.put("msg", "支付失败");
                   return res;
           }
           JSONObject result = payService.wxPay(spbill_create_ip, openId, payOrder);
           res.put("code", 1);
           res.put("msg", result.getString("result"));
           res.put("data", result);
           order.setPersonnelId(personnelId);
           orderService.updateOrder(order);
       }catch (NullPointerException e)
       {
           e.printStackTrace();
           res.put("code",0);
           res.put("msg","pay fail");
       }catch (Exception e)
       {
           e.printStackTrace();
           res.put("code",0);
           res.put("msg","pay fail");
       }
       System.out.println(res);
        return res;
    }
    /**
     * 获取IP地址
     * @param request
     * @return
     */
    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

    /**
     * //1待签约 2待服务 (3待付定金 4待付预付款 5待付尾款)==服务中 6完成 -1取消
     * @param request
     * @return
     */
    @RequestMapping("/confirmPay")
    public JSONObject confirmPay(@RequestBody JSONObject request){
        JSONObject res= new JSONObject();
        try {
            Integer id = request.getInteger("id");
            String token = request.getString("token");
            String orderNumber = request.getString("orderNumber");
            Integer personnelId =request.getInteger("aunt_id");
            User user =userService.findUserById(id);
            if(token.equals(TokenService.getToken(user)))
            {
                if(request.getInteger("type").intValue()== 4)
                {
                    LectureOrders lectureOrders = orderService.findLectureOrderByOrderNumber(orderNumber);
                    lectureOrders.setStatus(2);
                    lectureOrders.setPayTime(new Date());
                    orderService.updatLectureOrder(lectureOrders);
                    res.put("code",1);
                    res.put("msg","完成支付");
                }
                else if(request.getInteger("type").intValue() == 3)
                {

                    Order order =orderService.findOrderByOrderNumber(orderNumber);
                    if(order.getStatus() == 3)
                    {
                        order.setStatus(6);
                        billService.orderCheckout(personnelId,order.getId());
                        res.put("msg","完成订单");
                    }
                    else{
                        order.setStatus(3);
                        order.setPayTime(new Date());
                        res.put("msg","完成支付");
                    }
                    orderService.updateOrder(order);
                    res.put("code",1);

                }
                else
                {
                    Order order=orderService.findOrderByOrderNumber(orderNumber);
                    OrderStatus orderStatus =new OrderStatus();
                    orderStatus.setOrderNumber(orderNumber);
                    orderStatus.setOrderId(order.getId());
                    Integer status=order.getStatus();
                    switch (status) {
                        case 4:
                            order.setStatus(5);
                            order.setPersonnelId(personnelId);
                            orderStatus.setStatus(5);
                            orderStatus.setPayTime(new Date());
                            orderStatus.setPayMoney(order.getMoneyAdvance());
                            res.put("code",1);
                            res.put("msg","预付款支付完成");
                            break;
                        case 5:
                            order.setStatus(6);
                            order.setPayTime(new Date());
                            orderStatus.setStatus(6);
                            orderStatus.setPayTime(new Date());
                            orderStatus.setPayMoney(order.getMoneyFinal());
                            billService.orderCheckout(personnelId,order.getId());
                            res.put("code",1);
                            res.put("msg","尾款支付完成");
                            break;
                        case 2:
                            if(request.getInteger("type")== 2)
                            {
                                order.setStatus(5);
                                order.setPayTime(new Date());
                                orderStatus.setStatus(5);
                                orderStatus.setPayTime(new Date());
                                orderStatus.setPayMoney(order.getMoneyAdvance());
                                res.put("code", 1);
                                res.put("msg", "预付款支付完成");
                            }
                            else {
                                order.setStatus(4);
                                order.setPayTime(new Date());
                                orderStatus.setStatus(4);
                                orderStatus.setPayTime(new Date());
                                orderStatus.setPayMoney(order.getMoneyBargin());
                                order.setPersonnelId(personnelId);
                                res.put("code",1);
                                res.put("msg","定金支付完成");
                            }
                            break;
                        default:
                            res.put("code", 0);
                            res.put("msg", "支付失败");
                            return res;
                    }
                    orderService.updateOrder(order);
                    orderService.addOrderStatus(orderStatus);
                }
           }

        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
            res.put("code",0);
            res.put("msg","用户或订单不存在");
        }
        System.out.println(res.toJSONString());
        return  res;
    }
}
