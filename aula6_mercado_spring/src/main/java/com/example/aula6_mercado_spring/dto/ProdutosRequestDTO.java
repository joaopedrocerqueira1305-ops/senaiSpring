package com.example.aula6_mercado_spring.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutosRequestDTO {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    
    @NotBlank(message = "O preço é obrigatório")
    private Double preco;
}
