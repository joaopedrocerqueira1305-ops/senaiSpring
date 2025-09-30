package com.example.aula5.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/")
public class BemVindoController {
    @GetMapping
    public String mensagem() {
        return "Bem-vindo";
    }
}
