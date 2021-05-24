package com.analugmrs.desafio.domain.resources;

import com.analugmrs.desafio.domain.exception.ErrorException;
import com.analugmrs.desafio.domain.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetVehiclesDetails {

    @Autowired
    private FipeUriHelper fipeUriHelper;

    public FipeDetails fipeDetails(VehicleFipeRequest vehicleFipeRequest) throws Exception{
        List<FipeBrands> brands  = fipeUriHelper.getAllBrands();
        String idBrand = getBrandId(brands, vehicleFipeRequest.getBrand());

        FipeModelsWrapper modelsWrapper  = fipeUriHelper.getAllModels(idBrand);
        String idModel = getModelId(modelsWrapper, vehicleFipeRequest.getModel());

        List<FipeYears> years  = fipeUriHelper.getAllYears(idBrand, idModel);
        String idYear = getYearId(years, vehicleFipeRequest.getYear());

        FipeDetails fipeDetails = fipeUriHelper.getDetails(idBrand, idModel, idYear);
        return  fipeDetails;
    }

    private String getBrandId(List<FipeBrands> brands, String brand) throws Exception {
        for (FipeBrands b:brands) {
            if (b.getNome().equals(brand)){
                return  b.getCodigo();
            }
        }
        throw new ErrorException(HttpStatus.BAD_REQUEST, "Invalid vehicle brand");
    }

    private String getModelId(FipeModelsWrapper modelsWrapper, String model) throws Exception {
        List<FipeModels> models = modelsWrapper.getModelos();
        for (FipeModels m:models) {
            if (m.getNome().equals(model)){
                return  m.getCodigo();
            }
        }
        throw new ErrorException(HttpStatus.BAD_REQUEST, "Invalid vehicle model");
    }

    private String getYearId(List<FipeYears> years, String year) throws Exception {
        for (FipeYears y:years) {
            if (y.getNome().equals(year)){
                return  y.getCodigo();
            }
        }
        throw new ErrorException(HttpStatus.BAD_REQUEST, "Invalid vehicle year");
    }

    public boolean isVehicleOk(VehiclesPost vehiclesPost) throws Exception {

        List<FipeBrands> brands  = fipeUriHelper.getAllBrands();
        String brandId = getBrandId(brands, vehiclesPost.getBrand());

        FipeModelsWrapper modelsWrapper  = fipeUriHelper.getAllModels(brandId);
        String modelId = getModelId(modelsWrapper, vehiclesPost.getModel());

        List<FipeYears> years  = fipeUriHelper.getAllYears(brandId, modelId);
        String yearId = getYearId(years, vehiclesPost.getYear());
        if(!brandId.isEmpty() && !modelId.isEmpty() && !yearId.isEmpty()) return true;
        throw new ErrorException(HttpStatus.BAD_REQUEST, "there was an error when registering car");
    }
}
