package com.analugmrs.desafio.config;

import com.analugmrs.desafio.repository.entities.Users;
import com.analugmrs.desafio.repository.entities.Vehicles;
import com.analugmrs.desafio.repository.repositories.UsersRepository;
import com.analugmrs.desafio.repository.repositories.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private VehiclesRepository vehiclesRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
