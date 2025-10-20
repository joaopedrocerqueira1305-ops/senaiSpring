package com.example.aula8.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoRequestDTO {
    @NotBlank(message = "o nome é obrigatório")
    private String nome;
    
    @NotBlank(message = "o nome é obrigatório")
    private String lote;
    
    @NotBlank(message = "o nome é obrigatório")
    private String validade;
    
    @NotBlank(message = "o nome é obrigatório")
    private String categoria;
    
    @NotBlank(message = "o nome é obrigatório")
    private int quantidade;
}
