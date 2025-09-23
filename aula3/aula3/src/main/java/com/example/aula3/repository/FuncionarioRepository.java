package com.example.Aula3.repository;

import com.example.Aula3.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {
}
