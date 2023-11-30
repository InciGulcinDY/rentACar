package com.tobeto.rentACar.services.dtos.cars.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCarByBrandResponse {
    private String plateNumber;
    private String brand;
    private String model;
}
