package com.zeropoint.homemaking.Controllers.Back;

import com.zeropoint.homemaking.Services.UserService;
import com.zeropoint.homemaking.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value ="/userlist")
    @ResponseBody
    public List<User> getUserList ()
    {
        return userService.getAll();
        // return userMapper.selectAll();

    }
    @RequestMapping("/add")
    @ResponseBody
    public String addUser(@RequestBody User user){
        userService.add(user);
        return null;
    }
    @RequestMapping("/search")
    @ResponseBody
    public List<User> search()
    {
        Map<String,String > map= new HashMap<>();
        map.put("userName","客户");
        map.put("start_time","2019-06-29");
        map.put("end_time","2019-07-09");
        return userService.search(map);
    }
}
