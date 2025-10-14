package com.example.aula7.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioRequestDTO {
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;
    
    @NotBlank(message = "O E-mail é obrigatório.")
    @Email(message = "Deve ser um E-mail válido.")
    private String email;
    
    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 5, max = 25, message = "A senha deve ter entre 5 e 25 caracteres.")
    private String senha;
}
