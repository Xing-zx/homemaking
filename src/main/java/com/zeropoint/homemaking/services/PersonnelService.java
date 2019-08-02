package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.Certificate;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.domain.Speciality;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public interface PersonnelService {

    /** 列表/筛选
     * @param condition 筛选条件
     * @return 阿姨列表
     */
    List<ServicePersonnel> getList(Map<String,Object> condition);

    /** 特长
     * @param id  阿姨id
     * @return 特长
     */
    List<String> getSpeciality(Integer id);
    List<String> getSpecialityId(Integer id);
    /** 证书
     * @param id 阿姨id
     * @return 证书
     */
    List<String>getCertificate(Integer id);
    List<String>getCertificateId(Integer id);

    List<String> getChildList(String name);

    ServicePersonnel findById(Integer id);

    int update(ServicePersonnel personnel);

    ServicePersonnel findByUserId(Integer userId);

    int updateSpeciality(Integer[] categoryIds, Integer personnelId);

    int updateCertificate(Certificate certificate);

    int addCertificate(Certificate certificate);

    int addPersonnel(ServicePersonnel personnel);

    Certificate findCertificatByid(Integer id);

    List<ServicePersonnel> findPersonnelByids(String[] ids);

    int getPersonCount(Integer personnelId);



}
