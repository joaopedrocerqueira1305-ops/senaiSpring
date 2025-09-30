package com.example.aula5.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody Alunos alunos){
        alunosService.salvar(alunos);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Aluno cadastrado com sucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateAlunos(@PathVariable UUID id, @RequestBody Alunos alunos){
        alunosService.updateAlunos(id, alunos);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Aluno atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable UUID id){
        alunosService.excluir(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Aluno excluído com sucesso"));

    }
}
