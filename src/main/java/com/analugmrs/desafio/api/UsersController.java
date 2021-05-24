package com.analugmrs.desafio.api;

import com.analugmrs.desafio.domain.exception.ErrorException;
import com.analugmrs.desafio.domain.models.UserVehicles;
import com.analugmrs.desafio.domain.models.UsersPost;
import com.analugmrs.desafio.domain.resources.UsersResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UsersResources usersResources;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void insert(@RequestBody UsersPost obj) throws Exception {
        usersResources.addUser(obj);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{cpf}/vehicles")
    public UserVehicles findbyId(@PathVariable Long cpf) throws Exception {
        return usersResources.getUserWithAllVehiclesList(cpf);

    }
}
