package com.example.Aula3.service;

import com.example.Aula3.model.Cliente;
import com.example.Aula3.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    public Cliente salvar(Cliente cliente){
        if (clienteRepository.findByProtocoloAtendimento(cliente.getProtocoloAtendimento()).isPresent()){
            throw new RuntimeException("CLiente ja cadastrado");
        }
        return clienteRepository.save(cliente);
    }
}
