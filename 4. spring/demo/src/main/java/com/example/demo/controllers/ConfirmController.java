package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ConfirmController {
    @GetMapping("/confirm/{code}")
    public String confirmUser(@PathVariable("code") String code) {
        return null;
    }
}
