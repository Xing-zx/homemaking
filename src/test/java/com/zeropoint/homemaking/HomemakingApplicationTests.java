package com.zeropoint.homemaking;

import com.zeropoint.homemaking.dao.LectureMapper;
import com.zeropoint.homemaking.dao.LectureOrdersMapper;
import com.zeropoint.homemaking.domain.LectureOrders;
import com.zeropoint.homemaking.services.LectureService;
import com.zeropoint.homemaking.services.PayService;
import com.zeropoint.homemaking.utils.ConvertUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomemakingApplicationTests {
    @Autowired
    LectureService lectureService;
    @Autowired
    PayService payService;
    @Autowired
    LectureOrdersMapper lectureOrdersMapper;
    @Test
    public void contextLoads() {

    }
    @Test
    public void stringConvert()
    {

        System.out.println(ConvertUtil.getImgStr("<img src=\"https://jz.dian0.top:443/2019/08//20190808140941.jpg\" alt=\"20190808140941.jpg\">11111111222222222222222"));
    }
}
