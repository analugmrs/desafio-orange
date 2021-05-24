package com.analugmrs.desafio.domain.resources;

import com.analugmrs.desafio.externalServices.IFipeExternalService;
import com.analugmrs.desafio.domain.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@Service
public class FipeUriHelper {
    @Autowired
    private IFipeExternalService fipeExternalService;

    public List<FipeBrands> getAllBrands(){
        return fipeExternalService.getAllBrands();
    }

    public FipeModelsWrapper getAllModels(String brandId){
        URI uri = URI.create("https://parallelum.com.br/fipe/api/v1/carros/marcas/" + brandId);
        return fipeExternalService.getAllModels(uri);
    }

    public List<FipeYears> getAllYears(String brandId, String modelId){
        URI uri = URI.create("https://parallelum.com.br/fipe/api/v1/carros/marcas/" + brandId + "/modelos/" + modelId);
        return fipeExternalService.getAllAnos(uri);
    }

    public FipeDetails getDetails(String brandId, String modelId, String yearId){
        URI uri = URI.create("https://parallelum.com.br/fipe/api/v1/carros/marcas/" + brandId + "/modelos/" + modelId + "/anos/" + yearId);
        return fipeExternalService.getDetails(uri);
    }



}
