package com.example.ativ.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ativ.model.Veiculo;
import com.example.ativ.repository.VeiculoRepository;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> listarTodos(){
        return veiculoRepository.findAll();
    }

    public Veiculo salvar(Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }

    // update
    public Veiculo updateVeiculo(Long id, Veiculo veiculo){
        if(!veiculoRepository.existsById(id)){
            throw new RuntimeException("Veiculo não encontrado");
        }
        veiculo.setId(id);
        return veiculoRepository.save(veiculo);
    }
    // Delete
    public void excluirVeiculo(Long id){
        if (!veiculoRepository.existsById(id)){
            throw new RuntimeException("Veiculo não encontrado");
        }
        veiculoRepository.deleteById(id);
    }
}
