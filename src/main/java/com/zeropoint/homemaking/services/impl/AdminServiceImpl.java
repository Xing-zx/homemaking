package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.AdminMapper;
import com.zeropoint.homemaking.domain.Admin;
import com.zeropoint.homemaking.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashMap;

import java.util.List;
import java.util.Map;

/**
 * @author zx
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /** 加载用户密码
     * @param s username
     * @return admin
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
          Admin admin=adminMapper.selectByName(s);
          if(admin == null)
          {
              throw new UsernameNotFoundException(String.format("Admin with name =%s is not found",s));

          }
            System.out.println("authentication is going to be done");
            System.out.println(admin.getPassword());
            return admin;
        }

    @Override
    public List<Admin> selectAll(Map<String, String> condition) {
        //区分条件
        if (condition == null)
        {
            return adminMapper.selectAll();
        }
        return adminMapper.selectByCondition(condition);
    }

    @Override
    public String add(Admin record) {
        //密码编码
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String ecodedpwd=passwordEncoder.encode(record.getPassword());
        record.setPassword(ecodedpwd);
        if(adminMapper.insert(record)>0)
        {
            return "success";

        }
        return "fail";
    }

    @Override
    public String delete(Integer[] ids) {
        if (adminMapper.deleteByIds(ids)>0)
        {
            return "success";
        }
        return "fail";
    }


}

