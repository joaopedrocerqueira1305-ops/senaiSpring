package com.example.aula8.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula8.dto.FuncionarioRequestDTO;
import com.example.aula8.dto.FuncionarioResponseDTO;
import com.example.aula8.service.FuncionarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;
    
    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDTO>> listar(){
        return ResponseEntity
        .ok()
        .body(funcionarioService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody FuncionarioRequestDTO dto){
        funcionarioService.salvarFuncionario(dto);
        return ResponseEntity
            .created(null)
            .body(Map.of(
                "mensagem", "Cadastrado com sucesso",
                "sucesso", true
            ));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(
        @PathVariable Long id,
        @Valid @RequestBody FuncionarioRequestDTO dto){
            funcionarioService.atualizarFuncionario(id, dto);
            return ResponseEntity
                .ok()
                .body(Map.of(
                    "mensagem", "Funcionário atualizado com sucesso",
                    "sucesso", true
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable Long id){
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity
            .ok()
            .body(Map.of(
                "mensagem", "Funcionário excluído com sucesso",
                "sucesso", true
            ));
    }
}