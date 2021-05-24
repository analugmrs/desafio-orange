package com.analugmrs.desafio.domain.models;

import java.util.List;

public class UserVehicles {
    private String name;
    private String email;
    private Long cpf;
    private String birthDate;
    private List<VehiclesWithInfo> vehicles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<VehiclesWithInfo> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehiclesWithInfo> vehicles) {
        this.vehicles = vehicles;
    }

    public UserVehicles(String name, String email, Long cpf, String birthDate, List<VehiclesWithInfo> vehicles) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.vehicles = vehicles;
    }
}
