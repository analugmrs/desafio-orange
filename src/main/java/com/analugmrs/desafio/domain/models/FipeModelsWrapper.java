package com.analugmrs.desafio.domain.models;

import java.util.List;

public class FipeModelsWrapper {

    private List<FipeModels> modelos;

    private List<FipeYears> anos;

    public FipeModelsWrapper(){

    }

    public FipeModelsWrapper(List<FipeModels> modelos, List<FipeYears> anos) {
        this.modelos = modelos;
        this.anos = anos;
    }

    public List<FipeModels> getModelos() {
        return modelos;
    }

    public void setModelos(List<FipeModels> modelos) {
        this.modelos = modelos;
    }

    public List<FipeYears> getAnos() {
        return anos;
    }

    public void setAnos(List<FipeYears> anos) {
        this.anos = anos;
    }
}
