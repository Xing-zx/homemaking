package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.Certificate;
import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.domain.Speciality;
import com.zeropoint.homemaking.domain.Stores;

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
    List<String> getSpecialityName(Integer id);
    List<Speciality> getSpecialities(Integer id);
    List<String> getSpecialityId(Integer id);
    /** 证书
     * @param id 阿姨id
     * @return 证书
     */
    List<String>getCertificateName(Integer id);
    List<String>getCertificateId(Integer id);
    List<Certificate> getCertificates(Integer id);
    List<String> getChildList(String name);

    ServicePersonnel findById(Integer id);

    int update(ServicePersonnel personnel);

    ServicePersonnel findByUserId(Integer userId);

    int updateSpeciality(Integer[] categoryIds, Integer personnelId);

    int updateCertificate(Certificate certificate);

    int addCertificate(Certificate certificate);

    int addPersonnel(ServicePersonnel personnel);

    Certificate addCheck(Integer personnelId,Integer categoryId);

    Certificate findCertificatByid(Integer id);

    List<ServicePersonnel> findPersonnelByids(String[] ids);

    int getPersonCount(Integer personnelId);




    List<ServicePersonnel> selectByCondition1(int page, int rows, String name, Integer storesId, Integer workType, String startTime, String endTime);

    int count1(String name,Integer storesId,Integer workType,String startTime,String endTime);

    /*未审核员工*/
    List<ServicePersonnel> selectByConditions2(int page,int rows,String name,Integer workType,String startTime,String endTime);

    int counts2(String name,Integer workType,String startTime,String endTime);

    /** 特长
     * @param id  阿姨id
     * @return 特长
     */
    List<Speciality> getSpeciality1(Integer id);

    /** 证书
     * @param id 阿姨id
     * @return 证书
     */
    List<Certificate>getCertificate1(Integer id);


    List<String> getChildList1(String name);

    /*查询单个*/
    ServicePersonnel SelectIds1(Integer id);

    /*查询单个*/
    ServicePersonnel SelectIds2(Integer id);

    /*获取门店下拉框*/
    List<Stores> selectStores1();

    void delete1(Integer[] ids);

    int updateByPrimaryKey(ServicePersonnel record);

    int updateStatus(Integer id,Integer status,Integer storesId);

    List<Speciality> selectSpeciality(Integer personnelId);

    List<Certificate> selectCertificate(Integer personnelId);

    int updateCertificate(Integer id,Integer status);

    int updateBrokerage1(Integer id,Double allBrokerage,Double withdrawalBrokerage);

    int updateBrokerage2(Integer id,Double allBrokerage,Double withdrawalBrokerage);

}
