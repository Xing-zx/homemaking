package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.*;
import com.zeropoint.homemaking.domain.*;
import com.zeropoint.homemaking.services.LectureService;
import com.zeropoint.homemaking.services.OrderService;
import com.zeropoint.homemaking.vo.PersonnelOrder;
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
    UserRequirementMapper requirementMapper;
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
    public List<Order> findOrderByUserId(Integer userId) {
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
    public int addUserRequirement(UserRequirement userRequirement) {
        return requirementMapper.insert(userRequirement);
    }

    @Override
    public UserRequirement findUserRequirementById(Integer id) {
        return requirementMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<OrderStatus> getOrderStatus(Integer orderId) {
        return orderStatusMapper.selectByOrderId(orderId);
    }

    @Override
    public int addOrderStatus(OrderStatus orderStatus) {
        return orderStatusMapper.insert(orderStatus);
    }


}