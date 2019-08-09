package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.*;
import com.zeropoint.homemaking.domain.*;
import com.zeropoint.homemaking.services.LectureService;
import com.zeropoint.homemaking.services.OrderService;
import com.zeropoint.homemaking.vo.PersonnelOrder;
import com.zeropoint.homemaking.vo.UserOder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    LectureOrdersMapper lectureOrdersMapper;
    @Autowired
    LectureMapper lectureMapper;
    @Autowired
    LectureService lectureService;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderStatusMapper orderStatusMapper;
    @Override
    public LectureOrders generateLectureOrder(Integer id, Integer userId) {
        String orderNumber =OrderService.generateOrderNumber(id.toString(),"0");
        LectureOrders lectureOrders =new LectureOrders();
        lectureOrders.setLectureId(id);
        lectureOrders.setUserId(userId);
        lectureOrders.setStatus(1);
        lectureOrders.setCreateTime(new Date());
        lectureOrders.setAmount(lectureMapper.selectByPrimaryKey(id).getAmount());
        lectureOrders.setOrderNumber(orderNumber);
        lectureOrdersMapper.insert(lectureOrders);
        System.out.println(lectureOrders.getId());
        return lectureOrders;
    }
    @Override
    public LectureOrders findLectureOrderById(Integer id) {
        return lectureOrdersMapper.selectByPrimaryKey(id);
    }

    @Override
    public LectureOrders findLectureOrderByOrderNumber(String orderNumber) {
        return lectureOrdersMapper.findByOrderNumber(orderNumber);
    }

    @Override
    public List<LectureOrders> findLectureOrderByUserId(Integer id) {
        return lectureOrdersMapper.findLectureOrderByUserId(id);
    }

    @Override
    public LectureOrders findLectureOrderByOrderIdAndId(Integer id, Integer userId) {
        return lectureOrdersMapper.findByUserIdAndId(id,userId);
    }

    @Override
    public int updatLectureOrder(LectureOrders lectureOrders) {
        return lectureOrdersMapper.updateByPrimaryKey(lectureOrders);
    }

    @Override
    public String lectureOrderCheck(Integer id, Integer userId) {

        Lecture lecture = lectureMapper.selectByPrimaryKey(id);
        if(lecture ==null)
        {
            return "该线下课程不存在";
        }
        Date currentTime=new Date();
        System.out.println(currentTime);
        if (currentTime.after(lecture.getRegisterEnd()) || currentTime.before(lecture.getRegisterStart()))
        {
            return "该线下课程报名已终止";
        }
        if(lecture.getMaxCount().intValue() <= lecture.getCurrentCount())
        {
            return "该线下课程人数已满";
        }
        if(lectureOrdersMapper.findByUserIdAndId(id,userId) != null )
        {
            if((lectureOrdersMapper.findByUserIdAndId(id,userId).getStatus()) == 1)
            {
                return "goTopay";
            }
            return "您已经报名改课程";
        }
        return "ok";


    }
    @Override
    public String orderCheck(Integer personnelId, Date workStart, Date workEnd) {
        List<Order>  hourlyworkerOrders=orderMapper.selectByPersonnelId(personnelId);
        if(hourlyworkerOrders!=null)
        {
            for(Order order:hourlyworkerOrders)
            {
                System.out.println(workEnd+""+order.getWorkStartTime());
                if(order.getWorkStartTime().before(workEnd) && order.getWorkStartTime().after(workStart))
                {
                    return  "时间冲突";
                }
                if(order.getWorkEndTime().after(workStart) && order.getWorkEndTime().before(workEnd))
                {
                    return  "时间冲突";
                }
                if(order.getWorkEndTime().equals(workEnd)&& order.getWorkStartTime().equals(workStart))
                {
                    return  "时间冲突";
                }
            }
        }
        return "ok";

    }
    @Override
    public int addOrder(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public Order findOrderByOrderNumber(String orderNumber) {
        return orderMapper.selectByOrderNumber(orderNumber);
    }

    @Override
    public int updateOrder(Order Order) {
        return orderMapper.updateByPrimaryKey(Order);
    }

    @Override
    public Order findById(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public List<UserOder> findOrderByUserId(Integer userId) {
        return orderMapper.selectByUserId(userId);
    }

    @Override
    public List<Order> findOrderByPersonnelId(Integer personnelId) {
        return orderMapper.selectByPersonnelId(personnelId);
    }

    @Override
    public List<PersonnelOrder> findPersonnelOrderByPersonnelId(Integer personnelId) {
        return orderMapper.selectPersonnelOrderByPersonnelId(personnelId);
    }

    @Override
    public List<OrderStatus> getOrderStatus(Integer orderId) {
        return orderStatusMapper.selectByOrderId(orderId);
    }

    @Override
    public int addOrderStatus(OrderStatus orderStatus) {
        return orderStatusMapper.insert(orderStatus);
    }

    @Override
    public int insert1(Order record) {
        return orderMapper.insert1(record);
    }

    @Override
    public List<Order> selectAll1(Integer page, Integer rows, Integer type, String name, String endTime, String startTime) {
        return orderMapper.selectAll1(page, rows, type, name, endTime, startTime);
    }

    @Override
    public int count1(Integer type, String name, String endTime, String startTime) {
        return orderMapper.count1(type, name, endTime, startTime);
    }

    @Override
    public int delete1(Integer[] ids) {
        return orderMapper.delete1(ids);
    }

    @Override
    public Order selectKey1(Integer id) {
        return orderMapper.selectKey1(id);
    }

    @Override
    public List<ServicePersonnel> serviceSelect1(Integer maxage,Integer minage,Integer workType) {

        System.out.println(maxage+"---------------"+minage+"-------------------"+workType);
        return orderMapper.serviceSelect1(maxage, minage, workType);
    }

    @Override
    public int counts1(Integer[] ids) {
        return orderMapper.counts1(ids);
    }

    @Override
    public List<Order> selectOrder1(Integer page, Integer rows, Integer type, String name, Integer status, String endTime, String startTime) {
        return orderMapper.selectOrder1(page, rows, type, name, status, endTime, startTime);
    }

    @Override
    public int countOrder1(Integer type, Integer status, String name, String endTime, String startTime) {
        return orderMapper.countOrder1(type, status, name, endTime, startTime);
    }

    @Override
    public ServicePersonnel personnelView1(Integer id) {
        return orderMapper.personnelView1(id);
    }


    @Override
    public int updatemoneyTotal(Integer id, String hetongImgsrc, Double moneyTotal,Integer status,
                                String endTime,String startTime,String assignIds,
                                Double moneyBargin,Double moneyAdvance,Double moneyFinal,Double moneyActual) {
        return orderMapper.updatemoneyTotal(id, hetongImgsrc, moneyTotal,status,endTime,startTime,assignIds,moneyBargin,moneyAdvance,moneyFinal,moneyActual);
    }


}
