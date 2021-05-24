package com.analugmrs.desafio.repository.services;

import com.analugmrs.desafio.domain.exception.ErrorException;
import com.analugmrs.desafio.repository.entities.Vehicles;
import com.analugmrs.desafio.repository.repositories.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiclesService {

    @Autowired
    private VehiclesRepository repository;

    public List<Vehicles> findAllByOwner_Cpf(Long cpf) throws ErrorException {
        List<Vehicles> vehiclesList = repository.findAllByOwner_Cpf(cpf);
        if(vehiclesList.isEmpty()) throw new ErrorException(HttpStatus.BAD_REQUEST, "This user has no registered vehicle");
        return vehiclesList;
    }

    public void save(Vehicles vehicles){
        repository.save(vehicles);
    }
}
