package com.analugmrs.desafio.domain.resources;

import com.analugmrs.desafio.domain.exception.ErrorException;
import com.analugmrs.desafio.domain.models.FipeDetails;
import com.analugmrs.desafio.domain.models.VehicleFipeRequest;
import com.analugmrs.desafio.domain.models.VehiclesPost;
import com.analugmrs.desafio.domain.models.VehiclesWithInfo;
import com.analugmrs.desafio.repository.entities.Users;
import com.analugmrs.desafio.repository.entities.Vehicles;
import com.analugmrs.desafio.repository.services.UsersService;
import com.analugmrs.desafio.repository.services.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VehiclesResources {
    @Autowired
    private VehiclesService vehiclesService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private GetVehiclesDetails getVehiclesDetails;

    public void addVehicle(VehiclesPost vehiclesPost) throws Exception {
        if(getVehiclesDetails.isVehicleOk(vehiclesPost)){
            Users user = usersService.findById(vehiclesPost.getCpfOwner());
            Vehicles vehicles = new Vehicles(vehiclesPost.getBrand(), vehiclesPost.getModel(), vehiclesPost.getYear(), user);
            vehiclesService.save(vehicles);
        }
    }

    public List<Vehicles> getAllVehiclesByOwnerCpf(Long cpf) throws Exception {
        return vehiclesService.findAllByOwner_Cpf(cpf);
    }

    public List<VehiclesWithInfo> getAllVehiclesWithInfo(Long cpf) throws Exception {
        List<Vehicles> vehiclesList = getAllVehiclesByOwnerCpf(cpf);
        List<VehiclesWithInfo> vehiclesWithInfoList = new ArrayList<>();
        for (Vehicles v: vehiclesList) {
            vehiclesWithInfoList.add(new VehiclesWithInfo(
                    v.getBrand(),
                    v.getModel(),
                    v.getYear(),
                    casterDay(v.getYear()),
                    isActiveCaster(casterDay(v.getYear())),
                    getPrice(v.getBrand(), v.getModel(), v.getYear())
            ));
        }
        return vehiclesWithInfoList;
    }

    private String getPrice(String brand, String model, String year) throws Exception {
            VehicleFipeRequest vehicleFipeRequest = new VehicleFipeRequest(brand, model, year.toString());
            FipeDetails vehicleDetails = getVehiclesDetails.fipeDetails(vehicleFipeRequest);
            return vehicleDetails.getValor();
    }

    private boolean isActiveCaster(String casterDay) throws Exception {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        if(dayOfWeek == 1 || dayOfWeek == 7)
        {
            return false;
        }
        if(dayOfWeek == 2 && casterDay.equals("segunda-feira"))
        {
            return true;
        }
        if(dayOfWeek == 3 && casterDay.equals("terça-feira"))
        {
            return true;
        }
        if(dayOfWeek == 4 && casterDay.equals("quarta-feira"))
        {
            return true;
        }
        if(dayOfWeek == 5 && casterDay.equals("quinta-feira"))
        {
            return true;
        }
        if(dayOfWeek == 6 && casterDay.equals("sexta-feira"))
        {
            return true;
        }
        else{
            return false;
        }
    }

    private String casterDay(String year) throws ErrorException {
        String onlyYear = year.substring(0, 4);
        String yearDigit = onlyYear.substring(3);
        if(yearDigit.equals("0") || yearDigit.equals("1")) {
            return "segunda-feira";
        }
        if(yearDigit.equals("2") || yearDigit.equals("3")) {
            return "terça-feira";
        }
        if(yearDigit.equals("4") || yearDigit.equals("5")) {
            return "quarta-feira";
        }
        if(yearDigit.equals("6") || yearDigit.equals("7")) {
            return "quinta-feira";
        }
        if(yearDigit.equals("8") || yearDigit.equals("9")) {
            return "sexta-feira";
        }
        throw new ErrorException(HttpStatus.BAD_REQUEST, "Invalid year");
    }
}
