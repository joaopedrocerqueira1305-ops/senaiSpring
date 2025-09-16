package com.example.Aula2.Model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tab_endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String numero;

    public Endereco() {
    }

    public Endereco(UUID id, String logradouro, String numero) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
