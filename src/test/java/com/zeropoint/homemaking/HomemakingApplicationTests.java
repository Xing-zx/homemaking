package com.zeropoint.homemaking;

import com.zeropoint.homemaking.dao.LectureMapper;
import com.zeropoint.homemaking.dao.LectureOrdersMapper;
import com.zeropoint.homemaking.domain.LectureOrders;
import com.zeropoint.homemaking.services.LectureService;
import com.zeropoint.homemaking.services.PayService;
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
        String place ="湖南省郴州市北湖区";
        place= place.replaceAll("省","省/");
        place=place.replaceAll("市","市/");
        place=place.replaceAll("区","区/");
        if(place.charAt(place.length()-1)=='/')
        {
            place=place.substring(0,place.length()-1);
        }
        System.out.println(place);
    }
}
