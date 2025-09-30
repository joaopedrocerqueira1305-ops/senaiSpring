package com.example.aula5.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aula5.model.Alunos;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, UUID> {
    Optional<Alunos> findByEmail(String email);
}
