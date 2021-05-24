package com.analugmrs.desafio.repository.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    @Id
    private Long cpf;
    private String birthDate;

    @OneToMany(mappedBy = "owner")
    private List<Vehicles> vehicles;

    public Users(){

    }

    public Users(String name, String email, Long cpf, String birthDate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

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

    public List<Vehicles> getVehicles() {
        return vehicles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return getEmail().equals(users.getEmail()) && getCpf().equals(users.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getCpf());
    }
}
