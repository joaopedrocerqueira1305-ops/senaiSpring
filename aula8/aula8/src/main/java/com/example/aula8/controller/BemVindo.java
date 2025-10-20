package com.example.aula8.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/")
public class BemVindo {
    @GetMapping
    public String bemVindo() {
        return ("Bem Vindo");
    }
    
}
