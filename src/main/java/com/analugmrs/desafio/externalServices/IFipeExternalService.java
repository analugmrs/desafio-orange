package com.analugmrs.desafio.externalServices;

import com.analugmrs.desafio.domain.models.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;
import java.util.List;

@FeignClient(url = "https://parallelum.com.br/fipe/api/v1/carros/", name = "fipe")
public interface IFipeExternalService  {
        @GetMapping("marcas")
        List<FipeBrands> getAllBrands();

        @GetMapping("modelos")
        FipeModelsWrapper getAllModels(URI baseUrl);

        @GetMapping("anos")
        List<FipeYears> getAllAnos(URI baseUrl);

        @GetMapping
        FipeDetails getDetails(URI baseUrl);
}
