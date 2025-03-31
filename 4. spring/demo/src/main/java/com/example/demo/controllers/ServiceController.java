package com.example.demo.controllers;

import com.example.demo.dto.ServiceDto;
import com.example.demo.dto.ServiceForm;
import com.example.demo.services.ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping("/service")
    @ResponseBody
    public ResponseEntity<ServiceDto> addService(@RequestBody ServiceForm form) {
        return ResponseEntity.ok(serviceService.addService(form));
    }

    //localhost:8080/papers/service/search?page=0&size=3
    @GetMapping("/papers/service/search")
    @ResponseBody
    public ResponseEntity<List<ServiceDto>> search(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size,
            @RequestParam(value = "q", required = false) String query,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "direction", required = false) String direction
            ) {
        return ResponseEntity.ok(serviceService.search(page, size, query, sort, direction));
    }
}
