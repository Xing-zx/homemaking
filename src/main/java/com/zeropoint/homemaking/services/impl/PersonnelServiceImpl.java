package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.CategoryMapper;
import com.zeropoint.homemaking.dao.CertificateMapper;
import com.zeropoint.homemaking.dao.ServicePersonnelMapper;
import com.zeropoint.homemaking.dao.SpecialityMapper;
import com.zeropoint.homemaking.domain.Certificate;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.domain.Speciality;
import com.zeropoint.homemaking.services.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Service
public class PersonnelServiceImpl  implements PersonnelService {
    @Autowired
    ServicePersonnelMapper personnelMapper;
    @Autowired
    SpecialityMapper specialityMapper;
    @Autowired
    CertificateMapper certificateMapper;
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<ServicePersonnel> getList(Map<String, Object> condition) {
        if (condition == null)
        {
            return personnelMapper.selectAll();
        }
        return personnelMapper.selectByCondition(condition);
    }

    @Override
    public List<Speciality> getSpeciality(Integer id) {
        return specialityMapper.selectByPersonnelId(id);
    }

    @Override
    public List<Certificate> getCertificate(Integer id) {
        return certificateMapper.selectByPersonnelId(id);
    }

    @Override
    public List<String> getChildList(String name) {

        return categoryMapper.getChildListByName(name);
    }
}
