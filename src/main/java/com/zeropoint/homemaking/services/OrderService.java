package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.LectureOrders;
import com.zeropoint.homemaking.domain.Order;
import com.zeropoint.homemaking.domain.OrderStatus;
import com.zeropoint.homemaking.vo.PersonnelOrder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author Administrator
 */
public interface OrderService {
    /**
     *  生成线下课程订单
     * @param id
     * @param userId
     * @return
     */
     LectureOrders generateLectureOrder(Integer id, Integer userId);
     LectureOrders findLectureOrderById(Integer id);
     LectureOrders findLectureOrderByOrderNumber(String orderNumber);
     List<LectureOrders> findLectureOrderByUserId(Integer id);
     LectureOrders findLectureOrderByOrderIdAndId(Integer id,Integer userId);
     int updatLectureOrder(LectureOrders lectureOrders);

    int addOrder(Order order);
    /**
     *  生成随机唯一订单号
     * @param id
     * @param type
     * @return
     */
     static String generateOrderNumber(String id,String type)
     {
         SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
         String newDate=sdf.format(new Date());
         String result="";
         Random random=new Random();
         for(int i=0;i<6;i++){
             result+=random.nextInt(10);
         }
         return newDate+result+type+id;
     }
     String lectureOrderCheck(Integer id, Integer userId);
     String orderCheck(Integer personnelId,Date workStart, Date workEnd);
     Order findOrderByOrderNumber(String orderNumber);

     int updateOrder(Order order);

     Order findById(Integer orderId);
     List<Order> findOrderByUserId(Integer userId);
     List<Order> findOrderByPersonnelId(Integer personnelId);
     List<PersonnelOrder> findPersonnelOrderByPersonnelId(Integer personnelId);

     
     List<OrderStatus> getOrderStatus(Integer orderId);
     int addOrderStatus(OrderStatus orderStatus);

}
