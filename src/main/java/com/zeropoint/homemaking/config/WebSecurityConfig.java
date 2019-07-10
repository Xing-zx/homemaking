package com.zeropoint.homemaking.config;

import com.zeropoint.homemaking.Services.AdminService;
import com.zeropoint.homemaking.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * @param http
     * @throws Exception
     */

    @Autowired
    private AdminService adminService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/js/**","/static/**","/lib/**","/pages/**","/json/**","/login.html","/admin/add").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .defaultSuccessUrl("/index.html",true)
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .headers().frameOptions().disable();
//                .authorizeRequests()
//                .antMatchers("/admin/**").hasRole("5") // /admin开头的url需要ADMIN角色才能访问
//                .antMatchers("/anonymous*").anonymous() // 未登录用户可访问
//                .antMatchers("/login*").permitAll() // 所有人可访问
//                .anyRequest().authenticated() // 其他url都需要登陆才能访问
//                .and() // 前面antMatchers等相当于authorizeRequests的子标签，and将标签闭合
//                .formLogin()
//                .loginPage("/login.html") // 指定登陆页面url
//                .loginProcessingUrl("/perform_login") // 处理登陆的url
//                .defaultSuccessUrl("/homepage.html", true) // 登陆成功重定向到该页面
//                .failureHandler(authenticationFailureHandler())
//                .and()
//                .logout()
//                .logoutUrl("/perform_logout") //指定登出请求的url
             //   .deleteCookies("JSESSIONID")
              //  .logoutSuccessHandler(logoutSuccessHandler())
             //   .and()
               // .exceptionHandling()
            //    .accessDeniedHandler(accessDeniedHandler());



    }
    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.adminService).passwordEncoder(new BCryptPasswordEncoder());
        System.out.println("configure");

    }





}
