package com.example.ativ.controller;

import java.util.List;
import java.util.Map;

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

import com.example.ativ.model.Veiculo;
import com.example.ativ.service.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> listar(){
        return veiculoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody Veiculo veiculo){
        veiculoService.salvar(veiculo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Veiculo cadastrado com sucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo){
        veiculoService.updateVeiculo(id, veiculo);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Veiculo atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluirVeiculo(@PathVariable Long id){
        veiculoService.excluirVeiculo(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Veiculo excluído com sucesso"));

    }
}
