package com.example.primeiro_projeto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class Welcome {

    @GetMapping

    public String mensagem() {
        return "Olá, mundo!";
    }

    @GetMapping("aluno")
    public String aluno() {
        return "Olá, aluno!";
    }

    @GetMapping("/dev")
    public String dev() {
        return "Olá, dev!";
    }

    @GetMapping("joao")
    public String joao() {
        return "Pedro :) " +
                " teste ";
    }
}

