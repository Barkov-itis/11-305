package com.example.demo.controllers;

import com.example.demo.dto.AjaxDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AjaxCsrfController {

    @GetMapping("/ajax")
    public String getAjaxPage() {
        return "ajax_csrf_example";
    }

    @PostMapping("/ajax")
    public ResponseEntity<?> logAjax(@RequestBody AjaxDto dto) {
        System.out.println(dto);
        return ResponseEntity.ok(dto);
    }

}
