package com.kivanc.spring.controller;


import com.kivanc.spring.entity.Product;
import com.kivanc.spring.service.ProductService;
import com.kivanc.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    @GetMapping("/404")
    public String errorPage() {

        return "user/404";
    }

    @GetMapping("/")
    public String home(Model theModel, Authentication authentication) {

        List<Product> theProducts = productService.findAllProducts();

        theModel.addAttribute("products", theProducts);
        theModel.addAttribute("username", authentication.getName());


        return "user/index";
    }

}