package com.vlad.pp_311_3.controller;

import com.vlad.pp_311_3.model.User;
import com.vlad.pp_311_3.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "/admin";
    }


    @GetMapping(value = "/admin/add")
    public String addPage(Model model) {
        model.addAttribute("newUser", new User());
        return "addUser";
    }

    @PostMapping(value = "/admin/add")
    public String addUser(@ModelAttribute("newUser") User newUser) {
        userService.save(newUser);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/edit/{id}")
    public String editPage(Model model, @PathVariable("id") long id) {
        model.addAttribute("updateUser", userService.getById(id));

        return "adminEditUser";
    }

    @PostMapping(value = "/admin/edit")
    public String update(@ModelAttribute("user") User updatedUser) {
        userService.save(updatedUser);

        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(id);

        return "redirect:/admin";
    }
}
