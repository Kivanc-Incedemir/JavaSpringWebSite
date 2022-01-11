package com.kivanc.spring.controller;

import com.kivanc.spring.entity.Product;
import com.kivanc.spring.entity.User;
import com.kivanc.spring.service.UserService;
import com.kivanc.spring.user.VM.CrmUserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserSettingsController {

    @Autowired
    UserService userService;

    @GetMapping("/user-settings")
    public String showHome() {

        return "user/user-settings";
    }

    @GetMapping("/showFormForUpdate")
    public String update(@RequestParam("userName") String userName,
                         Model theModel) {
        User theUser = userService.findByUserName(userName);

        theModel.addAttribute("user", theUser);

        return "user/user-settings";

    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") CrmUserVM crmUserVM) {
        userService.update(crmUserVM);

        return "redirect:/products/list";

    }
}
