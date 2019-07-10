package com.zeropoint.homemaking.Services;

import com.zeropoint.homemaking.domain.ServicePersonnel;

import java.util.List;
import java.util.Map;

public interface ServicePersonnelService {

    int add(ServicePersonnel record);
    int delete(int id);
    int deleteByids(Integer[] ids);
    List<ServicePersonnel> selectAll();
    List<ServicePersonnel> selectByQuery(Map<String,String> condition);


}
