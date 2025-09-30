package com.example.aula5.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/dev")
public class DevController {
    @GetMapping
    public String mensagem() {
        return "João Pedro C.";
    }
}
