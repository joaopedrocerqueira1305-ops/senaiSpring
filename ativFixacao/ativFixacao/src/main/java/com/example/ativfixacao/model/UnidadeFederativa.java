package com.example.ativfixacao.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UnidadeFederativa {
    BAHIA("BA"),
    SAO_PAULO("SP"),
    RIO_DE_JANEIRO("RJ");

    private String sigla;

    public String getSigla() {
        return sigla;
    }
}
