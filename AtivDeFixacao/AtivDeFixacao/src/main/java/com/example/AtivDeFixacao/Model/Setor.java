package com.example.AtivDeFixacao.Model;

public enum Setor {
    ENGENHARIA("Engenharia"),
    SAUDE("Saúde"),
    JURIDICO("Jurídico");

    private String texto;

    Setor(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
