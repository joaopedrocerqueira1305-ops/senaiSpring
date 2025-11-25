package com.example.aula6_mercado_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.aula6_mercado_spring.dto.ProdutosRequestDTO;
import com.example.aula6_mercado_spring.dto.ProdutosResponseDTO;
import com.example.aula6_mercado_spring.model.ProdutosModel;
import com.example.aula6_mercado_spring.repository.ProdutosRepository;

@Service
public class ProdutosService {
    @Autowired
    private ProdutosRepository produtosRepository;

    //CONSULTAR TODOS OS Produtos
    public List<ProdutosResponseDTO> listarTodos() {
        return produtosRepository
            .findAll()
            .stream()
            .map(u -> new ProdutosResponseDTO(u.getNome(), u.getPreco()))
            .toList();
    }

    //SALVAR UM USUARIO
    public ProdutosModel salvarProduto(ProdutosRequestDTO dto){
        if (produtosRepository.findByNome(dto.getNome()).isPresent()) {
            throw new RuntimeException("Produto ja cadastrado");
            
        }
        ProdutosModel novoProdutosModel = new ProdutosModel();
        novoProdutosModel.setNome(dto.getNome());
        novoProdutosModel.setPreco(dto.getPreco());

        novoProdutosModel.save(novoProdutosModel);
        return novoProdutosModel;
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
