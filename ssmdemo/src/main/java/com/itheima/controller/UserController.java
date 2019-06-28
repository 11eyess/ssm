package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(User user, HttpSession session){
        User user1 = userService.login(user);
        if (user1!=null){
            session.setAttribute("user",user1);
            return "redirect:/student/findAll";
        }else {
            session.setAttribute("msg","账号或密码错误");
            return "login";
        }

    }
}
