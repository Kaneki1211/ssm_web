package com.cl.controller;


import com.cl.domain.User;
import com.cl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public void findAll() {

    }

    @RequestMapping("/enterLogin")
    public String enterLogin() {
        return "login";
    }
    @RequestMapping("/enterRegister")
    public String enterRegister() {
        return "register";
    }
    @RequestMapping("/login")
    public String login(User user , HttpServletRequest request , HttpServletResponse response) {
        boolean b = userService.userLogin(user);
        if(b) {
            request.getSession().setAttribute("sucUser",user);
            return "redirect:/goods/findAll";
        }else {
            request.setAttribute("errorMsg","用户名或密码错误！");
            request.setAttribute("errorUser",user);
            return "forward:enterLogin";
        }


    }
    @RequestMapping("/register")
    public String register(User user, HttpServletRequest request) {
        boolean b = userService.userRegister(user);
        if(b) {
            request.setAttribute("sucRegister","注册成功！");
            return "forward:enterLogin";
        }else {
            request.getSession().setAttribute("rerrorMsg","用户名重复!");
            request.getSession().setAttribute("rerrorUser",user);
            return "forward:enterRegister";
        }
    }
    @RequestMapping("/quit")
    public void quit(HttpServletRequest request , HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("sucUser",null);
        response.sendRedirect(request.getContextPath()+"/goods/findAll");
    }
    @RequestMapping("/back")
    public String back(HttpServletRequest request , HttpServletResponse response) throws IOException {
        return "redirect:/goods/findAll";
    }



}
