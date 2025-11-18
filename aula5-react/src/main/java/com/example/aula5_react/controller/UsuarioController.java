package com.example.aula5_react.controller;

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

import com.example.aula5_react.dto.UsuarioRequestDTO;
import com.example.aula5_react.dto.UsuarioResponseDTO;
import com.example.aula5_react.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar(){
        return ResponseEntity
        .ok()
        .body(usuarioService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody UsuarioRequestDTO dto){
        usuarioService.salvarUsuario(dto);
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
        @Valid @RequestBody UsuarioRequestDTO dto){
            usuarioService.atualizarUsuario(id, dto);
            return ResponseEntity
                .ok()
                .body(Map.of(
                    "mensagem", "Funcionário atualizado com sucesso",
                    "sucesso", true
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity
            .ok()
            .body(Map.of(
                "mensagem", "Funcionário excluído com sucesso",
                "sucesso", true
            ));
    }
}
