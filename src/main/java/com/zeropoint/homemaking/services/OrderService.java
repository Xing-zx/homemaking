package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.*;
import com.zeropoint.homemaking.vo.PersonnelOrder;
import com.zeropoint.homemaking.vo.UserOder;
import org.apache.ibatis.annotations.Param;

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
    List<UserOder> findOrderByUserId(Integer userId);
    List<Order> findOrderByPersonnelId(Integer personnelId);
    List<PersonnelOrder> findPersonnelOrderByPersonnelId(Integer personnelId);

    List<OrderStatus> getOrderStatus(Integer orderId);
    int addOrderStatus(OrderStatus orderStatus);

    int insert1(Order record);

    List<Order> selectAll1(Integer page,Integer rows,Integer type,String name,String endTime,String startTime);

    int count1(Integer type,String name,String endTime,String startTime);

    int delete1(Integer[] ids);

    Order selectKey1(Integer id);

    List<ServicePersonnel> serviceSelect1(Integer maxage,Integer minage,Integer workType);

    int counts1(Integer[] ids);

    List<Order> selectOrder1(Integer page,Integer rows,Integer type,String name,Integer status,String endTime,String startTime);

    int countOrder1(Integer type,Integer status,String name,String endTime,String startTime);

    ServicePersonnel personnelView1(Integer id);

    int updatemoneyTotal(Integer id,String hetongImgsrc,Double moneyTotal,Integer status,
                         String endTime,String startTime,String assignIds,
                         Double moneyBargin,Double moneyAdvance,Double moneyFinal,Double moneyActual);

}
