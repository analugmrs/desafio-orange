package com.analugmrs.desafio.repository.services;

import com.analugmrs.desafio.domain.exception.ErrorException;
import com.analugmrs.desafio.repository.entities.Users;
import com.analugmrs.desafio.repository.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repository;

    public List<Users> findAll(){
        return repository.findAll();
    }

    public Users findById(Long cpf) throws ErrorException {
        Optional<Users> obj = repository.findById(cpf);
        if(!obj.isPresent()){throw new ErrorException(HttpStatus.BAD_REQUEST, "User does not exist");}
        return obj.get();
    }

    public boolean cpfExists(Long cpf) {
        return repository.existsById(cpf);
    }

    public boolean emailExists(String email) {
        return repository.existsByEmail(email);
    }

    public void save(Users user){
        repository.save(user);
    }

}
