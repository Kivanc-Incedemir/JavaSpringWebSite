package com.kivanc.spring.controller;


import com.kivanc.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

@Autowired
UserService userService;


 @GetMapping("/404")
 public String errorPage(){

     return "user/404";
 }

    @GetMapping("/")
    public String home(){

        return "user/index";
    }



}
