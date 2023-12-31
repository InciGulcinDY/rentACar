package com.tobeto.rentACar.services.dtos.cars.response;

import com.tobeto.rentACar.services.dtos.brands.response.GetAllBrandsByCustomerResponse;
import com.tobeto.rentACar.services.dtos.models.response.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCarsResponse {
    private String plateNumber;
    private GetAllBrandsByCustomerResponse brand;
    private GetAllModelsResponse model;
    private int passengerCapacity;
    private  int baggageCapacity;
    private String image;
}
