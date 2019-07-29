package com.zeropoint.homemaking.vo;

import com.zeropoint.homemaking.domain.ServicePersonnel;
import com.zeropoint.homemaking.domain.Speciality;

/**
 * @author Administrator
 */
public class PersonnelInfo {
    private ServicePersonnel servicePersonnel;
    private Speciality speciality;

    public ServicePersonnel getServicePersonnel() {
        return servicePersonnel;
    }

    public void setServicePersonnel(ServicePersonnel servicePersonnel) {
        this.servicePersonnel = servicePersonnel;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
