package com.zeropoint.homemaking.DAO;

import com.zeropoint.homemaking.Entitys.ServicePersonnel;
import java.util.List;

public interface ServicePersonnelMapper {
    int insert(ServicePersonnel record);

    List<ServicePersonnel> selectAll();
}