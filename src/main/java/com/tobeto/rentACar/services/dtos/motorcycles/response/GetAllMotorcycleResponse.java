package com.tobeto.rentACar.services.dtos.motorcycles.response;

import lombok.Data;

@Data
public class GetAllMotorcycleResponse {
    private String plateNumber;
    private int passengerCapacity;
    private String image;
}
