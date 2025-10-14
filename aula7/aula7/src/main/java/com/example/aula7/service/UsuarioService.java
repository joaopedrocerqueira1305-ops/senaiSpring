package com.example.aula7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.aula7.dto.UsuarioRequestDTO;
import com.example.aula7.dto.UsuarioResponseDTO;
import com.example.aula7.model.Usuario;
import com.example.aula7.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //Salvar novo usuario
    public Usuario salvarUsuario(UsuarioRequestDTO usuarioRequestDTO){
        usuarioRepository.findByEmail(usuarioRequestDTO.getEmail())
        .ifPresent(u -> {throw new IllegalArgumentException("E-mail já cadastrado.");} );
        
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequestDTO.getNome());
        usuario.setEmail(usuarioRequestDTO.getEmail()); 
        usuario.setSenha(bCryptPasswordEncoder.encode(usuarioRequestDTO.getSenha()));

        usuarioRepository.save(usuario);
        return usuario;
    }

    //Listar todos os usuarios
    public List<UsuarioResponseDTO> listarTodos(){
        return usuarioRepository.findAll().stream().map(u -> new UsuarioResponseDTO(u.getNome(), u.getEmail()))
        .toList();
    }
}
