package com.vlad.pp_311_3.controller;

import com.vlad.pp_311_3.model.User;
import com.vlad.pp_311_3.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/user/{id}")
//    public String showUser(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("user", userService.getById(id));
//
//        return "user";
//    }

    @GetMapping("/user")
    public String showUserPage(Model model, User user) {
        model.addAttribute("user", user.toString());

        return "user";
    }

}

