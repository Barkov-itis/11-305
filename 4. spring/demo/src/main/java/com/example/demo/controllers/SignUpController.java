package com.example.demo.controllers;

import com.example.demo.dto.UserForm;
import com.example.demo.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUp")
    public String getSignUpPage(){
        return "sign_up_page";
    }

    @PostMapping("/signUp")
    public String signUp(UserForm form){
        System.out.println("************");
        System.out.println(form.getEmail());
        System.out.println(form.getPassword());
        signUpService.addUser(form);
        return "redirect:/signUp";
    }
}
