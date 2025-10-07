package com.example.ativ.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ativ.model.Produto;
import com.example.ativ.repository.ProdutoReposiory;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoReposiory produtoReposiory;

    public List<Produto> listarTodos(){
        return produtoReposiory.findAll();
    }

    public Produto salvar(Produto produto){
        if (produtoReposiory.findByNome(produto.getNome()).isPresent()) {
            throw new RuntimeException("Produto ja cadastrado");
        }
        
        return produtoReposiory.save(produto);
    }

    // update
    public Produto updateProduto(Long id, Produto produto){
        if(!produtoReposiory.existsById(id)){
            throw new RuntimeException("Produto não encontrado");
        }
        produto.setId(id);
        return produtoReposiory.save(produto);
    }
    // Delete
    public void excluirProduto(Long id){
        if (!produtoReposiory.existsById(id)){
            throw new RuntimeException("Produto não encontrado");
        }
        produtoReposiory.deleteById(id);
    }
}
