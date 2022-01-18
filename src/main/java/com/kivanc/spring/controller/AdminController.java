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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;


    @GetMapping("/")
    public String home(Model theModel, Authentication authentication) {

        List<Product> theProducts = productService.findAllProducts();

        theModel.addAttribute("products", theProducts);
        theModel.addAttribute("username", authentication.getName());


        return "admin/index";
    }

    @GetMapping("/layout-static")
    public String layouts_1(){
        return "admin/layout-static";
    }
    @GetMapping("/layout-sidenav-light")
    public String layouts_2(){
        return "admin/layout-sidenav-light";
    }
    @GetMapping("/charts")
    public String charts(){
        return "admin/charts";
    }
    @GetMapping("/tables")
    public String tables(){
        return "admin/tables";
    }

}
