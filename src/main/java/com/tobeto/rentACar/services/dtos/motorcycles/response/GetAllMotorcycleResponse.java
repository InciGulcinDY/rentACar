package com.tobeto.rentACar.services.dtos.motorcycles.response;

import com.tobeto.rentACar.services.dtos.brands.response.GetAllBrandsByCustomerResponse;
import com.tobeto.rentACar.services.dtos.models.response.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllMotorcycleResponse {
    private String plateNumber;
    private GetAllBrandsByCustomerResponse brand;
    private GetAllModelsResponse model;
    private int passengerCapacity;
    private String image;
}
