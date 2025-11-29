package com.ecom.EcomProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProuctController {
    
    @GetMapping("/api")
    public String home() {
        return "Welcome to E-commerce Application";
    }



    

}
