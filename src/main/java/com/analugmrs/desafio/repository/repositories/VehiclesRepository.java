package com.analugmrs.desafio.repository.repositories;

import com.analugmrs.desafio.repository.entities.Vehicles;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehiclesRepository extends JpaRepository<Vehicles, Long> {
    List<Vehicles> findAllByOwner_Cpf(Long cpf);
}
