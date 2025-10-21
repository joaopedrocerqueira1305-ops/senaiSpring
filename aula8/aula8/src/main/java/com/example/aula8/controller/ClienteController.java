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

import com.example.aula8.dto.ClienteRequestDTO;
import com.example.aula8.dto.ClienteResponseDTO;
import com.example.aula8.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listar(){
        return ResponseEntity
        .ok()
        .body(clienteService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody ClienteRequestDTO dto){
        clienteService.salvarCliente(dto);
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
        @Valid @RequestBody ClienteRequestDTO dto){
            clienteService.atualizarCliente(id, dto);
            return ResponseEntity
                .ok()
                .body(Map.of(
                    "mensagem", "Cliente atualizado com sucesso",
                    "sucesso", true
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity
            .ok()
            .body(Map.of(
                "mensagem", "Cliente excluído com sucesso",
                "sucesso", true
            ));
    }
}