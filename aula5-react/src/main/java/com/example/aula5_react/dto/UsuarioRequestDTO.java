package com.example.aula5_react.dto;

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
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 200, message = "O nome não deve ter mais de 200 caracteres")
    private String nome;
    
    @NotBlank(message = "o e-mail é obrigatório")
    @Email(message = "Deve ser um e-mail válido")
    @Size(max = 200, message = "O e-mail não deve ter mais de 200 caracteres")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 3, message = "A senha deve ter no mínimo 4 caracteres")
    @Size(max = 100, message = "A senha não deve ter mais de 100 caracteres")
    private String senha;
}
