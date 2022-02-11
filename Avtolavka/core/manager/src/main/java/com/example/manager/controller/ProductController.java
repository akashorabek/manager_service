package com.example.manager.controller;

import com.example.manager.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ProductController {
    private ProductService service;

    @GetMapping
    public String root() {
        service.findAll().forEach(System.out::println);
        return "index";
    }
}
