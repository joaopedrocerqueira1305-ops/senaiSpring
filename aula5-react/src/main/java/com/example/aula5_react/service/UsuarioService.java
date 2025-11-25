package com.example.aula5_react.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.aula5_react.dto.UsuarioRequestDTO;
import com.example.aula5_react.dto.UsuarioResponseDTO;
import com.example.aula5_react.model.UsuarioModel;
import com.example.aula5_react.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //CONSULTAR TODOS OS USUARIoS
    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository
            .findAll()
            .stream()
            .map(u -> new UsuarioResponseDTO(u.getNome(), u.getEmail()))
            .toList();
    }

    //SALVAR UM USUARIO
    public UsuarioModel salvarUsuario(UsuarioRequestDTO dto){
        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email ja cadastrado");
            
        }
        UsuarioModel novoUsuario = new UsuarioModel();
        novoUsuario.setNome(dto.getNome());
        novoUsuario.setEmail(dto.getEmail());
        novoUsuario.setSenha(passwordEncoder.encode(dto.getSenha()));

        usuarioRepository.save(novoUsuario);
        return novoUsuario;
    }

    //ATUALIZAR UM FUNCIONARIO
    public UsuarioModel atualizarUsuario(Long id, UsuarioRequestDTO dto){
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
            
        }

        UsuarioModel atualizarUsuario = new UsuarioModel();
        atualizarUsuario.setId(id);
        atualizarUsuario.setNome(dto.getNome());
        atualizarUsuario.setEmail(dto.getEmail());
        atualizarUsuario.setSenha(passwordEncoder.encode(dto.getSenha()));

        usuarioRepository.save(atualizarUsuario);
        return atualizarUsuario;
    }
    
    //DELETAR UM FUNCIONARIO
    public void deletarUsuario(Long id){
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
            
        }
        usuarioRepository.deleteById(id);
    }
}
