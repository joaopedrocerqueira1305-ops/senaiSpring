package com.example.ativ.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ativ.model.Produto;

@Repository
public interface ProdutoReposiory extends JpaRepository<Produto, Long>{
    Optional<Produto> findByNome(String nome);
}
