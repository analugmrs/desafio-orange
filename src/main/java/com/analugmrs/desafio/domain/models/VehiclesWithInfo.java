package com.analugmrs.desafio.domain.models;

public class VehiclesWithInfo {
    private String brand;
    private String model;
    private String year;
    private String casterDay;
    private boolean activeCaster;
    private String price;

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

    public String getCasterDay() {
        return casterDay;
    }

    public void setCasterDay(String casterDay) {
        this.casterDay = casterDay;
    }

    public boolean isActiveCaster() {
        return activeCaster;
    }

    public void setActiveCaster(boolean activeCaster) {
        this.activeCaster = activeCaster;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public VehiclesWithInfo(String brand, String model, String year, String casterDay, boolean activeCaster, String price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.casterDay = casterDay;
        this.activeCaster = activeCaster;
        this.price = price;
    }
}
