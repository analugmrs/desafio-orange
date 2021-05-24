package com.analugmrs.desafio.domain.models;

public class VehiclesPost {
    private String brand;
    private String model;
    private String year;
    private Long cpfOwner;

    public VehiclesPost(String brand, String model, String year, Long cpfOwner) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.cpfOwner = cpfOwner;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Long getCpfOwner() {
        return cpfOwner;
    }

    public void setCpfOwner(Long cpfOwner) {
        this.cpfOwner = cpfOwner;
    }
}

