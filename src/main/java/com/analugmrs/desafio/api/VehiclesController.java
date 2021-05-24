package com.analugmrs.desafio.api;

import com.analugmrs.desafio.domain.models.VehiclesPost;
import com.analugmrs.desafio.domain.resources.VehiclesResources;
import com.analugmrs.desafio.repository.entities.Vehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehiclesController {

    @Autowired
    private VehiclesResources vehiclesResources;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void insert(@RequestBody VehiclesPost obj) throws Exception {
        vehiclesResources.addVehicle(obj);
    }
}
