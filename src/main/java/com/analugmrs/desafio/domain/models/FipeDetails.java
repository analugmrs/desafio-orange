package com.analugmrs.desafio.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FipeDetails {
    private String Valor;
    private String Marca;
    private String Modelo;
    private Integer AnoModelo;
    private String Combustivel;
    private String CodigoFipe;
    private String MesReferencia;
    private Integer TipoVeiculo;
    private String SiglaCombustivel;

    public FipeDetails (){
    }

    public String getValor() {
        return Valor;
    }

    @JsonProperty("Valor")
    public void setValor(String valor) {
        Valor = valor;
    }

    public FipeDetails(String valor, String marca, String modelo, Integer anoModelo, String combustivel, String codigoFipe, String mesReferencia, Integer tipoVeiculo, String siglaCombustivel) {
        Valor = valor;
        Marca = marca;
        Modelo = modelo;
        AnoModelo = anoModelo;
        Combustivel = combustivel;
        CodigoFipe = codigoFipe;
        MesReferencia = mesReferencia;
        TipoVeiculo = tipoVeiculo;
        SiglaCombustivel = siglaCombustivel;
    }

    public String getMarca() {
        return Marca;
    }

    @JsonProperty("Marca")
    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    @JsonProperty("Modelo")
    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public Integer getAnoModelo() {
        return AnoModelo;
    }

    @JsonProperty("AnoModelo")
    public void setAnoModelo(Integer anoModelo) {
        AnoModelo = anoModelo;
    }

    public String getCombustivel() {
        return Combustivel;
    }

    @JsonProperty("Combustivel")
    public void setCombustivel(String combustivel) {
        Combustivel = combustivel;
    }

    public String getCodigoFipe() {
        return CodigoFipe;
    }

    @JsonProperty("CodigoFipe")
    public void setCodigoFipe(String codigoFipe) {
        CodigoFipe = codigoFipe;
    }

    public String getMesReferencia() {
        return MesReferencia;
    }

    @JsonProperty("MesReferencia")
    public void setMesReferencia(String mesReferencia) {
        MesReferencia = mesReferencia;
    }

    public Integer getTipoVeiculo() {
        return TipoVeiculo;
    }

    @JsonProperty("TipoVeiculo")
    public void setTipoVeiculo(Integer tipoVeiculo) {
        TipoVeiculo = tipoVeiculo;
    }

    public String getSiglaCombustivel() {
        return SiglaCombustivel;
    }

    @JsonProperty("SiglaCombustivel")
    public void setSiglaCombustivel(String siglaCombustivel) {
        SiglaCombustivel = siglaCombustivel;
    }
}
