package com.ecom.EcomProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.EcomProject.model.Product;
import com.ecom.EcomProject.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProuctController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String home() {
        return "Welcome to E-commerce Application";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }

}
