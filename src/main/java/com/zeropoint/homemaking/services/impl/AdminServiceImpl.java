package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.AdminMapper;
import com.zeropoint.homemaking.domain.Admin;
import com.zeropoint.homemaking.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


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
    public void delete(Integer[] ids){
         adminMapper.delete(ids);
    }


    @Override
    public String update(Admin record) {
        if (adminMapper.updateByPrimaryKey(record) > 0)
        {
            return "success";
        }
        return  "fail";
    }

    @Override
    public int deleteByPrimaryKey1(Integer id) {
        return adminMapper.deleteByPrimaryKey1(id);
    }

    @Override
    public int insert1(Admin record) {
        return adminMapper.insert1(record);
    }

    @Override
    public Admin selectByPrimaryKey1(Integer id) {
        return adminMapper.selectByPrimaryKey1(id);
    }

    @Override
    public List<Admin> selectAll1() {
        return adminMapper.selectAll1();
    }

    @Override
    public int updateByPrimaryKey1(Admin record) {
        return adminMapper.updateByPrimaryKey1(record);
    }

    @Override
    public List<Admin> selectByCondition1(Integer page, Integer rows, String name, String role, String endTime, String startTime) {
        return adminMapper.selectByCondition1(page, rows, name, role, endTime, startTime);
    }

    @Override
    public int AdminCount1(String name, String role, String endTime, String startTime) {
        return adminMapper.AdminCount1(name, role, endTime, startTime);
    }

    @Override
    public void delete1(Integer[] ids) {
        adminMapper.delete1(ids);
    }

    @Override
    public Admin selectByName1(String name) {
        return adminMapper.selectByName1(name);
    }

    @Override
    public int updateStatus1(int id, int status) {
        return adminMapper.updateStatus1(id, status);
    }

    @Override
    public Admin login1(Admin admin) {
        return adminMapper.login1(admin);
    }


}

