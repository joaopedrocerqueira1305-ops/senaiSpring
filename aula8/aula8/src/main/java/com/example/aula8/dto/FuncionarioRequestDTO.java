package com.example.aula8.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FuncionarioRequestDTO {
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
    @Size(max = 200, message = "O nome não deve ter mais de 200 caracteres")
    private String nome;
    
    @NotBlank(message = "o e-mail é obrigatório")
    @Email(message = "Dev ser um e-mail válido")
    @Size(max = 200, message = "O e-mail não deve ter mais de 200 caracteres")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 4, message = "A senha deve ter no mínimo 4 caracteres")
    @Size(max = 100, message = "A senha não deve ter mais de 100 caracteres")
    private String senha;
}
