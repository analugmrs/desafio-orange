package com.analugmrs.desafio.repository.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Vehicles implements Serializable {
    private static final long serialVersionUID = 1l;

    private String brand;
    private String model;
    private String year;

    @ManyToOne
    @JoinColumn(name = "owner_id")

    private Users owner;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Vehicles() {

    }

    public Vehicles(String brand, String model, String year, Users owner) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.owner = owner;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public void setId(Long id) {
        this.id = id;
    }

}



