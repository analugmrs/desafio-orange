package com.analugmrs.desafio.domain.resources;

import com.analugmrs.desafio.domain.exception.ErrorException;
import com.analugmrs.desafio.domain.models.UserVehicles;
import com.analugmrs.desafio.domain.models.UsersPost;
import com.analugmrs.desafio.domain.models.VehiclesWithInfo;
import com.analugmrs.desafio.repository.entities.Users;
import com.analugmrs.desafio.repository.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersResources {
    @Autowired
    private UsersService usersService;
    @Autowired
    private VehiclesResources vehiclesResources;

    public void addUser(UsersPost usersPost) throws Exception {
        if(isCpfUnique(usersPost.getCpf()) & isEmailUnique(usersPost.getEmail()) && isCpfOk(usersPost.getCpf().toString())){
            Users users = new Users(usersPost.getName(), usersPost.getEmail(), usersPost.getCpf(), usersPost.getBirthDate());
            usersService.save(users);
        }
    }

    public UserVehicles getUserWithAllVehiclesList(Long cpf) throws Exception {
        Users user = usersService.findById(cpf);
        List<VehiclesWithInfo> vehiclesWithInfoList = vehiclesResources.getAllVehiclesWithInfo(cpf);
        UserVehicles userVehicles = new UserVehicles(user.getName(), user.getEmail(), user.getCpf(), user.getBirthDate(), vehiclesWithInfoList);
        return userVehicles;
    }

    private boolean isCpfUnique(Long cpf) throws Exception {
        boolean cpfExists = usersService.cpfExists(cpf);
        if(!cpfExists){return true;}
        else {throw new ErrorException(HttpStatus.BAD_REQUEST, "This cpf already exists in our database");}
    }

    private boolean isEmailUnique(String email) throws Exception {
        boolean emailExists  = usersService.emailExists(email);
        if(!emailExists){return true;}
        else {throw new ErrorException(HttpStatus.BAD_REQUEST, "This email already exists in our database");}
    }

    private boolean isCpfOk(String cpf) throws ErrorException {
        if(cpf.length() == 11)return true;
        else throw new ErrorException(HttpStatus.BAD_REQUEST, "Invalid CPF size");
    }
}
