package com.example.aula5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula5.model.Alunos;
import com.example.aula5.service.AlunosService;

@RestController
@RequestMapping("/alunos")
public class AlunosController {
    @Autowired
    private AlunosService alunosService;

    @GetMapping
    public List<Alunos> listar(){
        return alunosService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Alunos> salvar(@RequestBody Alunos alunos){
        alunosService.salvar(alunos);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(alunos);
    }
}
