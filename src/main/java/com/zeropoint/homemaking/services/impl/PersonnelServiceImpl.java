package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.CategoryMapper;
import com.zeropoint.homemaking.dao.CertificateMapper;
import com.zeropoint.homemaking.dao.ServicePersonnelMapper;
import com.zeropoint.homemaking.dao.SpecialityMapper;
import com.zeropoint.homemaking.domain.Certificate;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.domain.Speciality;
import com.zeropoint.homemaking.domain.Stores;
import com.zeropoint.homemaking.services.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Service
public class PersonnelServiceImpl  implements PersonnelService {

    @Autowired
    private ServicePersonnelMapper personnelMapper;
    @Autowired
    private SpecialityMapper specialityMapper;
    @Autowired
    private CertificateMapper certificateMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<ServicePersonnel> getList(Map<String, Object> condition) {
        if (condition == null)
        {
            return personnelMapper.selectAll();
        }
        List<ServicePersonnel> list=personnelMapper.selectByCondition(condition);
        if(list !=null) {
            try {
                for (ServicePersonnel personnel : list) {
                    List<String> specialities = getSpecialityName(personnel.getId());
                    if (specialities != null) {
                        personnel.setSpecialities(specialities);
                    }
                    List<String> certificates = getCertificateName(personnel.getId());
                    if (certificates != null) {
                        personnel.setCertificates(certificates);
                    }
                }
                System.out.println(list.size());
            } catch (NullPointerException e) {
                e.printStackTrace();

            }
        }
        return list;
    }

    @Override
    public List<String > getSpecialityName(Integer id) {
        List<Speciality> specialities=specialityMapper.selectByPersonnelId(id);
        List<String> list = new ArrayList<>();
        if (specialities != null) {
            for (Speciality speciality : specialities) {
                list.add(speciality.getName());
            }

        }
        return list;
    }

    @Override
    public List<Speciality> getSpecialities(Integer id) {
        return specialityMapper.selectByPersonnelId(id);
    }

    @Override
    public List<String> getSpecialityId(Integer id) {

        List<Speciality> specialities=specialityMapper.selectByPersonnelId(id);
        List<String> list = new ArrayList<>();
        if (specialities != null) {
            for (Speciality speciality : specialities) {
                list.add(speciality.getCategoryId().toString());
            }

        }
        return list;
    }

    @Override
    public List<String> getCertificateName(Integer id) {
        List<Certificate> certificates = certificateMapper.selectByPersonnelId(id);
        List<String > list = new ArrayList<>();
        if (certificates != null) {
            for (Certificate certificate : certificates) {
                if(certificate.getStatus()>0){
                    list.add(certificate.getName());
                }

            }
        }
        return list ;
    }

    @Override
    public List<String> getCertificateId(Integer id) {
        List<Certificate> certificates = certificateMapper.selectByPersonnelId(id);
        List<String > list = new ArrayList<>();
        if (certificates != null) {
            for (Certificate certificate : certificates) {
                if(certificate.getStatus()>0) {
                    list.add(certificate.getCategoryId().toString());
                }
            }
        }
        return list ;
    }

    @Override
    public List<Certificate> getCertificates(Integer id) {
        return certificateMapper.selectByPersonnelId(id);
    }

    @Override
    public List<String> getChildList(String name) {

        return categoryMapper.getChildListByName(name);
    }
    @Override
    public ServicePersonnel findById(Integer id) {
        return personnelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int  update(ServicePersonnel personnel) {

        return personnelMapper.updateByPrimaryKey(personnel);
    }
    @Override
    public ServicePersonnel findByUserId(Integer userId) {
        return personnelMapper.findByUserId(userId);
    }

    @Override
    public int updateSpeciality(Integer[] categoryIds, Integer personnelId) {
        int count=0;
        specialityMapper.deleteBunchByPersonnelId(personnelId);
        for(Integer categorId : categoryIds)
        {
            if(specialityMapper.selectByCategoryIdAndPersonnelId(categorId,personnelId) == null)
            {
                Speciality speciality=new Speciality();
                speciality.setCategoryId(categorId);
                speciality.setPersonnelId(personnelId);
                count += specialityMapper.insert(speciality);
            }

        }
        return count;
    }

    @Override
    public int updateCertificate(Certificate certificate) {
        return certificateMapper.updateByPrimaryKey(certificate);
    }

    @Override
    public int addCertificate(Certificate certificate) {

        if(certificateMapper.updateByPrimaryKey(certificate)==0)
        {
            return certificateMapper.insert(certificate);
        }
        else{

            return 0;
        }

    }

    @Override
    public int addPersonnel(ServicePersonnel personnel) {
        return personnelMapper.insert(personnel);
    }

    @Override
    public Certificate addCheck(Integer personnelId, Integer categoryId) {
        return certificateMapper.selectByCategoryAndPersonnel(personnelId,categoryId);
    }

    @Override
    public Certificate findCertificatByid(Integer id) {
        return certificateMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ServicePersonnel> findPersonnelByids(String[] ids) {
        List<ServicePersonnel> list=new ArrayList<>();
        for(String id:ids)
        {
            ServicePersonnel servicePersonnel=findById(Integer.parseInt(id));
            if(servicePersonnel!=null) list.add(servicePersonnel);
        }
        return list;
    }

    @Override
    public int getPersonCount(Integer personnelId) {
        return personnelMapper.getCountByUpline(personnelId);
    }


    @Override
    public List<ServicePersonnel> selectByCondition1(int page, int rows, String name, Integer storesId, Integer workType, String startTime, String endTime) {
        return personnelMapper.selectByCondition1(page,rows,name,storesId,workType,startTime,endTime);
    }

    @Override
    public int count1(String name,Integer storesId, Integer workType, String startTime, String endTime) {
        return personnelMapper.count1(name,storesId,workType,startTime,endTime);
    }

    @Override
    public List<ServicePersonnel> selectByConditions2(int page, int rows,String name, Integer workType, String startTime, String endTime) {
        return personnelMapper.selectByConditions2(page,rows,name,workType,startTime,endTime);
    }

    @Override
    public int counts2(String name, Integer workType, String startTime, String endTime) {
        return personnelMapper.counts2(name,workType,startTime,endTime);
    }

    @Override
    public List<Speciality> getSpeciality1(Integer id) {
        return specialityMapper.selectByPersonnelId(id);
    }

    @Override
    public List<Certificate> getCertificate1(Integer id) {
        return certificateMapper.selectByPersonnelId(id);
    }

    @Override
    public List<String> getChildList1(String name) {

        return categoryMapper.getChildListByName1(name);
    }

    @Override
    public ServicePersonnel SelectIds1(Integer id) {
        return personnelMapper.SelectIds1(id);
    }

    @Override
    public ServicePersonnel SelectIds2(Integer id) {
        return personnelMapper.SelectIds2(id);
    }

    @Override
    public List<Stores> selectStores1() {
        return personnelMapper.selectStores1();
    }

    @Override
    public void delete1(Integer[] ids){
        personnelMapper.delete1(ids);
    }

    @Override
    public int updateByPrimaryKey(ServicePersonnel record) {
        return personnelMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateStatus(Integer id, Integer status,Integer storesId) {
        return personnelMapper.updateStatus(id,status,storesId);
    }

    @Override
    public List<Speciality> selectSpeciality(Integer personnelId) {
        return personnelMapper.selectSpeciality(personnelId);
    }

    @Override
    public List<Certificate> selectCertificate(Integer personnelId) {
        return personnelMapper.selectCertificate(personnelId);
    }

    @Override
    public int updateCertificate(Integer id, Integer status) {
        return personnelMapper.updateCertificate(id,status);
    }


    @Override
    public int updateBrokerage1(Integer id,Double allBrokerage,Double withdrawalBrokerage) {
        return personnelMapper.updateBrokerage1(id,allBrokerage,withdrawalBrokerage);
    }

    @Override
    public int updateBrokerage2(Integer id,Double allBrokerage,Double withdrawalBrokerage) {
        return personnelMapper.updateBrokerage2(id,allBrokerage,withdrawalBrokerage);
    }

}
