package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Certificate;
import java.util.List;

public interface CertificateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Certificate record);

    Certificate selectByPrimaryKey(Integer id);

    List<Certificate> selectAll();

    List<Certificate> selectByPersonnelId(Integer id);

    int updateByPrimaryKey(Certificate record);
}