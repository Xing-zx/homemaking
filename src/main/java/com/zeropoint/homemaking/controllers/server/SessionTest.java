package com.zeropoint.homemaking.controllers.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author chowhin
 */
@RestController
@RequestMapping("/session")
public class SessionTest {

    @RequestMapping("/1")
    void session1(HttpServletRequest request)
    {
        HttpSession session =request.getSession();
        System.out.println("I am at 1 now,but my name is "+session.getAttribute("name"));
        System.out.println(session.getId());
        session.setAttribute("name","1");
    }
    @RequestMapping("/2")
    void session2(HttpServletRequest request)
    {
        HttpSession session =request.getSession();
        System.out.println("I am at 2 now, but my name is "+session.getAttribute("name"));
        System.out.println(session.getId());
        session.setAttribute("name","2");
    }
}
