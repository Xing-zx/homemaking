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


//    public List<Admin> getAll() {
//
//      int[] ids=new int[2];
//            ids[0]=1;
//            ids[1]=2;
//        return adminMapper.selectByQuery(ids);
//
//    }


//    public int deleteByQuery(List<Integer> ids) {
//        return adminMapper.deleteByQuery(ids);
//    }


//    public int Add(Admin record) {
//        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
//        String ecodedpwd=passwordEncoder.encode(record.getPassword());
//        record.setPassword(ecodedpwd);
//        return adminMapper.insert(record);
//    }

    /** 加载用户密码
     * @param s
     * @return admin
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
            Map<String,String> condition=new HashMap<>(16);
            condition.put("name",s);
            condition.put("role",null);
          List<Admin> admins=adminMapper.selectByCondition(condition);
            if(admins.get(0) == null)
            {
                throw new UsernameNotFoundException(String.format("Admin with name =%s is not found",s));
            }
            System.out.println("authentication is doing");
            return admins.get(0);
        }
    }

