package com.example.aula8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.aula8.dto.FuncionarioRequestDTO;
import com.example.aula8.dto.FuncionarioResponseDTO;
import com.example.aula8.model.FuncionarioModel;
import com.example.aula8.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //CONSULTAR TODOS FUNCIONARIS
    public List<FuncionarioResponseDTO> listarTodos() {
        return funcionarioRepository
            .findAll()
            .stream()
            .map(u -> new FuncionarioResponseDTO(u.getNome(), u.getEmail()))
            .toList();
    }

    //SALVAR UM FUNCIONARIO
    public FuncionarioModel salvarFuncionario(FuncionarioRequestDTO dto){
        if (funcionarioRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email ja cadastrado");
            
        }
        FuncionarioModel novoFuncionario = new FuncionarioModel();
        novoFuncionario.setNome(dto.getNome());
        novoFuncionario.setEmail(dto.getEmail());
        novoFuncionario.setSenha(passwordEncoder.encode(dto.getSenha()));

        funcionarioRepository.save(novoFuncionario);
        return novoFuncionario;
    }

    //ATUALIZAR UM FUNCIONARIO
    public FuncionarioModel atualizarFuncionario(Long id, FuncionarioRequestDTO dto){
        if (!funcionarioRepository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado");
            
        }

        FuncionarioModel atualizarFuncionario = new FuncionarioModel();
        atualizarFuncionario.setId(id);
        atualizarFuncionario.setNome(dto.getNome());
        atualizarFuncionario.setEmail(dto.getEmail());
        atualizarFuncionario.setSenha(passwordEncoder.encode(dto.getSenha()));

        funcionarioRepository.save(atualizarFuncionario);
        return atualizarFuncionario;
    }
    
    //DELETAR UM FUNCIONARIO
    public void deletarFuncionario(Long id){
        if (!funcionarioRepository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado");
            
        }
        funcionarioRepository.deleteById(id);
    }
}