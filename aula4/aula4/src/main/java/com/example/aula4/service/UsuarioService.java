package com.example.aula4.service;

import com.example.aula4.model.Usuario;
import com.example.aula4.reposiory.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired // construtor
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }
    public Usuario salvar(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
            throw new RuntimeException("Usuário ja cadastrado");
        }

        return usuarioRepository.save(usuario);
    }
    // update
    public Usuario atualizar(UUID id, Usuario usuario){
        if(!usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuário não encontrado");
        }
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }
    // Delete
    public void excluir(UUID id){
        if (!usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}
