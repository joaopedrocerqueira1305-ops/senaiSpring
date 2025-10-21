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

import com.example.aula8.dto.ProdutoRequestDTO;
import com.example.aula8.dto.ProdutoResponseDTO;
import com.example.aula8.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listar(){
        return ResponseEntity
        .ok()
        .body(produtoService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody ProdutoRequestDTO dto){
        produtoService.salvarProdutoModel(dto);
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
        @Valid @RequestBody ProdutoRequestDTO dto){
            produtoService.atualizarProdutoModel(id, dto);
            return ResponseEntity
                .ok()
                .body(Map.of(
                    "mensagem", "Produto atualizado com sucesso",
                    "sucesso", true
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable Long id){
        produtoService.deletarProdutoModel(id);
        return ResponseEntity
            .ok()
            .body(Map.of(
                "mensagem", "Produto excluído com sucesso",
                "sucesso", true
            ));
    }
}
