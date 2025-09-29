package com.example.aula4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BemvindoController {
    @GetMapping
    public String mensagem(){
        return "Bem-vindo";
    }

}
