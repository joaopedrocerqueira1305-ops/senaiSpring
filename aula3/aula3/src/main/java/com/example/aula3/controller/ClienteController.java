package com.example.Aula3.controller;

import com.example.Aula3.model.Cliente;
import com.example.Aula3.repository.ClienteRepository;
import com.example.Aula3.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listarTodos(){
        return clienteService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){
        clienteService.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
}
