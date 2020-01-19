package com.alipay.alipayspringdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author WindShadow
 * @verion 2020/1/11.
 */

@Controller
public class LoginHandler {

    // 模拟登陆验证
    public boolean loginService(String username, String password){

        return !( username == null || "".equals(username) || password == null || "".equals(password) );
    }

    @RequestMapping("/login")
    public String loginPage(){

        return "login";
    }

    @RequestMapping("/index")
    public String login(String username, String password, HttpSession session){

        if (!loginService(username,password))	return "redirect:login";
        session.setAttribute("username",username);
        return "index";
    }

}
