package com.example.aula8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula8.dto.ProdutoRequestDTO;
import com.example.aula8.dto.ProdutoResponseDTO;
import com.example.aula8.model.ProdutoModel;
import com.example.aula8.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    //CONSULTAR TODOS FUNCIONARIS
    public List<ProdutoResponseDTO> listarTodos() {
        return produtoRepository
            .findAll()
            .stream()
            .map(u -> new ProdutoResponseDTO(u.getNome(), u.getLote(), u.getValidade(), u.getCategoria() , u.getQuantidade()))
            .toList();
    }

    //SALVAR UM FUNCIONARIO
    public ProdutoModel salvarProdutoModel(ProdutoRequestDTO dto){
        if (produtoRepository.findByNome(dto.getNome()).isPresent()) {
            throw new RuntimeException("Produto ja cadastrado");
            
        }
        ProdutoModel novoProdutoModel = new ProdutoModel();
        novoProdutoModel.setNome(dto.getNome());
        novoProdutoModel.setLote(dto.getLote());
        novoProdutoModel.setValidade(dto.getValidade());
        novoProdutoModel.setCategoria(dto.getCategoria());
        novoProdutoModel.setQuantidade(dto.getQuantidade());

        produtoRepository.save(novoProdutoModel);
        return novoProdutoModel;
    }

    //ATUALIZAR UM FUNCIONARIO
    public ProdutoModel atualizarProdutoModel(Long id, ProdutoRequestDTO dto){
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
            
        }
        ProdutoModel atualizarProdutoModel = new ProdutoModel();
        atualizarProdutoModel.setNome(dto.getNome());
        atualizarProdutoModel.setLote(dto.getLote());
        atualizarProdutoModel.setValidade(dto.getValidade());
        atualizarProdutoModel.setCategoria(dto.getCategoria());
        atualizarProdutoModel.setQuantidade(dto.getQuantidade());

        produtoRepository.save(atualizarProdutoModel);
        return atualizarProdutoModel;
        
    }
    
    //DELETAR UM FUNCIONARIO
    public void deletarProdutoModel(Long id){
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
            
        }
        produtoRepository.deleteById(id);
    }
}