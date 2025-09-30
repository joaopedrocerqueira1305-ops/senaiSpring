package com.example.aula5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula5.model.Alunos;
import com.example.aula5.repository.AlunosRepository;

@Service
public class AlunosService {
    @Autowired
    private AlunosRepository alunosRepository;

    public List<Alunos> listarTodos(){
        return alunosRepository.findAll();
    }

    public Alunos salvar(Alunos alunos){
        if (alunosRepository.findByEmail(alunos.getEmail()).isPresent()) {
            throw new RuntimeException("Email ja cadastrado");
        }
        
        return alunosRepository.save(alunos);
    }
}
