package com.example.aula8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.aula8.dto.ClienteRequestDTO;
import com.example.aula8.dto.ClienteResponseDTO;
import com.example.aula8.model.ClienteModel;
import com.example.aula8.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    //CONSULTAR TODOS FUNCIONARIS
    public List<ClienteResponseDTO> listarTodos() {
        return clienteRepository
            .findAll()
            .stream()
            .map(u -> new ClienteResponseDTO(u.getNome(), u.getEmail(), u.getTelefone(), u.getFormaPagamento() , u.getEndereco()))
            .toList();
    }

    //SALVAR UM FUNCIONARIO
    public ClienteModel salvarCliente(ClienteRequestDTO dto){
        if (clienteRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email ja cadastrado");
            
        }
        ClienteModel novoCliente = new ClienteModel();
        novoCliente.setNome(dto.getNome());
        novoCliente.setEmail(dto.getEmail());
        novoCliente.setTelefone(dto.getTelefone());
        novoCliente.setFormaPagamento(dto.getFormaPagamento());
        novoCliente.setEndereco(dto.getEndereco());

        clienteRepository.save(novoCliente);
        return novoCliente;
    }

    //ATUALIZAR UM FUNCIONARIO
    public ClienteModel atualizarCliente(Long id, ClienteRequestDTO dto){
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
            
        }
        ClienteModel atualizarCliente = new ClienteModel();
        atualizarCliente.setNome(dto.getNome());
        atualizarCliente.setEmail(dto.getEmail());
        atualizarCliente.setTelefone(dto.getTelefone());
        atualizarCliente.setFormaPagamento(dto.getFormaPagamento());
        atualizarCliente.setEndereco(dto.getEndereco());

        clienteRepository.save(atualizarCliente);
        return atualizarCliente;
        
    }
    
    //DELETAR UM FUNCIONARIO
    public void deletarCliente(Long id){
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
            
        }
        clienteRepository.deleteById(id);
    }
}
