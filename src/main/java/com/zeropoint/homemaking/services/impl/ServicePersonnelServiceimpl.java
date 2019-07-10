package com.zeropoint.homemaking.Services.impl;

import com.zeropoint.homemaking.DAO.ServicePersonnelMapper;
import com.zeropoint.homemaking.Services.ServicePersonnelService;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service

public class ServicePersonnelServiceimpl implements ServicePersonnelService {


    @Autowired
    private ServicePersonnelMapper servicePersonnelMapper;

    @Override
    public int add(ServicePersonnel record) {
        return servicePersonnelMapper.insert(record) ;
    }

    @Override
    public int delete(int id) {
        return servicePersonnelMapper.deleteByPrimaryKey(id);
    }


    @Override
    public int deleteByids(Integer[] ids) {
        return servicePersonnelMapper.deleteByIds(ids);
    }

    @Override
    public List<ServicePersonnel> selectAll() {
        return null;
    }

    @Override
    public List<ServicePersonnel> selectByQuery(Map<String, String> condition) {
        return null;
    }
}
