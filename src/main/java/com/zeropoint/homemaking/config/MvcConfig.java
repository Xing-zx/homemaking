package com.zeropoint.homemaking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry)
    {
//        registry.addViewController("/index").setViewName("index");
//        registry.addViewController("/").setViewName("login");
//        registry.addViewController("/welcome").setViewName("pages/welcome.html");
//        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/error").setViewName("pages/404.html");
     //   registry.addViewController("/error").setViewName("404");

    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/");
//    }
}
