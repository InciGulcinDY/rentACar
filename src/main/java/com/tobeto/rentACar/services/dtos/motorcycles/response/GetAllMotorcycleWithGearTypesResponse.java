package com.tobeto.rentACar.services.dtos.motorcycles.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllMotorcycleWithGearTypesResponse {
    private String plateNumber;
    private String brand;
    private String model;
    private String gearType;
}
