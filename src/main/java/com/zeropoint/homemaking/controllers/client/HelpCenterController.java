package com.zeropoint.homemaking.controllers.client;

import com.alibaba.fastjson.JSONObject;
import com.zeropoint.homemaking.domain.Comment;
import com.zeropoint.homemaking.domain.Complaint;
import com.zeropoint.homemaking.domain.Order;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/api/helpCenter")
public class HelpCenterController {
    @Autowired
    ComplaintService complaintService;
    @Autowired
    UserService userService;
    @Autowired
    HelpCenterService helpCenterService;
    @Autowired
    PersonnelService personnelService;
    @Autowired
    OrderService orderService;
    @Autowired
    CustomersServices customersServices;
    /** 投诉反馈
     * @param request
     *  id,token,
     * 	title,		//标题
     * 	content,	//内容
     * @return
     */
    @RequestMapping("/feedback")
    public JSONObject feedback(@RequestBody JSONObject request){
        JSONObject res=new JSONObject();
        Integer id =request.getInteger("id");
        String token =request.getString("token");
        String title =request.getString("title");
        String content = request.getString("content");
        try{
            if(!TokenService.authToken(token,userService.findUserById(id)))
            {
                res.put("code",0);
                res.put("msg","token is invaild");
                return res;
            }
            Complaint complaint=new Complaint();
            complaint.setTitle(title);
            complaint.setContent(content);
            complaint.setUserId(id);
            helpCenterService.addComplaint(complaint);
            res.put("code",1);
            res.put("msg","feedback");
        }catch (NullPointerException e)
        {
            res.put("code",0);
            res.put("msg","提交错误");
        }
        System.out.println(res);
        return res;
    }
    /** 常见问题
     * @return { id,question,answer,},	//问题及其答案
     */
    @RequestMapping("/faq")
    public JSONObject faqList(){
        JSONObject res =new JSONObject();
        if(helpCenterService.getFaqList()==null)
        {
            res.put("code",0);
            res.put("msg","null");
            return res;
        }
        res.put("code",1);
        res.put("msg","faq");
        res.put("data",helpCenterService.getFaqList());
        return res;
    }
    @RequestMapping("/baseInfo")
    public JSONObject baseInfo(){
        JSONObject res =new JSONObject();
        JSONObject wrap =new JSONObject();
        wrap.put("aboutUsId",helpCenterService.findByName("关于平台").getId());
        wrap.put("aboutUsPhone",customersServices.selectAll(1,10).get(0).getPhone());
        wrap.put("securityId",helpCenterService.findByName("安全隐私说明").getId());
        res.put("code",1);
        res.put("msg","baseInfo");
        res.put("data",wrap);
        return res;
    }
    /**
     * id,token
     * 	order_id,	//已经完成的单号
     * 	score:		//1-5	int分数
     * 	content		//内容
     * @param request
     * @return
     */
    @RequestMapping("/comment")
    public  JSONObject comment(@RequestBody JSONObject request){
        JSONObject res= new JSONObject();
        Integer id=request.getInteger("id");
        Integer orderId=request.getInteger("order_id");
        Integer score=request.getInteger("score");
        String content=request.getString("content");
        System.out.println(request);
        Order order =orderService.findById(orderId);
        if(order.getHascomment()!=null &&order.getHascomment() )
        {
            res.put("code",0);
            res.put("msg","已评论");
            order.setHascomment(true);
            return res;
        }
        Comment comment= new Comment();
        comment.setOrderId(orderId);
        comment.setScore(score);
        comment.setContent(content);
        helpCenterService.addComment(comment);
        order.setHascomment(true);
        order.setCommentId(comment.getId());
        orderService.updateOrder(order);
        res.put("code",1);
        res.put("msg","ok");
        System.out.println(res.toJSONString());
        return res;
    }
}
