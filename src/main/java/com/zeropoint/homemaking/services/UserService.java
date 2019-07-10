package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;

public interface UserService extends UserDetailsService {

     List<User> getAll();
     int add(User user);
     int  delete(int key);
     List<User> search(Map<String ,String > condition);

}
