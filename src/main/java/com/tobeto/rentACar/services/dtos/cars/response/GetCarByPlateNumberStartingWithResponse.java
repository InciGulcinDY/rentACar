package com.tobeto.rentACar.services.dtos.cars.response;

import com.tobeto.rentACar.services.dtos.models.response.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCarByPlateNumberStartingWithResponse {
    private String plateNumber;
    private GetAllModelsResponse model;
    private int passengerCapacity;
    private  int baggageCapacity;
    private String image;
}
