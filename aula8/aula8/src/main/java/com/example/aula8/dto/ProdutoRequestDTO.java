package com.example.aula8.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoRequestDTO {
    @NotBlank(message = "o nome é obrigatório")
    @Size(max = 100, message = "o nome deve ter no máximo 100 caracteres")
    private String nome;
    
    @NotBlank(message = "o lote é obrigatório")
    private String lote;
    
    @NotBlank(message = "A validade é obrigatório")
    private String validade;
    
    @NotBlank(message = "A categoria é obrigatório")
    private String categoria;
    
    @NotNull(message = "A quantidade é obrigatório")    
    private int quantidade;
}
