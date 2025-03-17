package com.example.demo.controllers;

import com.example.demo.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("usersList", usersService.getAllUsers());
        return "users_page";
    }
}
