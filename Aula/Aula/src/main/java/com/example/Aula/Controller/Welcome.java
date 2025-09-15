package com.example.Aula.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping("/")
    public String mensagem() {
        return "Bem-vindo";
    }
    @GetMapping("/dev")
    public String dev() {
        return "Desenvolvedor: JoaoP ";
    }
}
