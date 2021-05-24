package com.analugmrs.desafio.domain.models;

public class FipeYears {

    private String nome;
    private String codigo;

    public FipeYears(){

    }

    public FipeYears(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
