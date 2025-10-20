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
public class ClienteRequestDTO {
    @NotBlank(message = "o nome é obrigatório")
    private String nome;
    
    @NotBlank(message = "o e-mail é obrigatório")
    @Email(message = "Dev ser um e-mail válido")
    @Size(max = 200, message = "O e-mail não deve ter mais de 200 caracteres")
    private String email;
    
    @NotBlank(message = "o telefone é obrigatório")
    private String telefone;
    
    @NotBlank(message = "o forma de pagamento é obrigatório")
    private String formaPagamento;
    
    @NotBlank(message = "o endereço é obrigatório")
    private String endereco;
}
