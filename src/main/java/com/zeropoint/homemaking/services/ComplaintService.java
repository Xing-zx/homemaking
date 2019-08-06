package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.Complaint;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
public interface ComplaintService {
    int add(Complaint complaint);

    int insert1(Complaint record);

    List<Complaint> selectAll1();

    List<Complaint> selectPage1(Integer page,Integer rows);

    int delete1(Integer[] ids);

    int count1();
}
