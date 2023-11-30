package com.tobeto.rentACar.services.dtos.vans.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllVanResponse {
    private String plateNumber;
    private String brand;
    private String model;
    private int passengerCapacity;
    private  int baggageCapacity;
    private String image;
}
