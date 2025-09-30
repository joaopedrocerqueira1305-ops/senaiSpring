package com.example.aula5.service;

import java.util.List;
import java.util.UUID;

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

    // update
    public Alunos updateAlunos(UUID id, Alunos alunos){
        if(!alunosRepository.existsById(id)){
            throw new RuntimeException("Usuário não encontrado");
        }
        alunos.setId(id);
        return alunosRepository.save(alunos);
    }
    // Delete
    public void excluir(UUID id){
        if (!alunosRepository.existsById(id)){
            throw new RuntimeException("Usuário não encontrado");
        }
        alunosRepository.deleteById(id);
    }
}
