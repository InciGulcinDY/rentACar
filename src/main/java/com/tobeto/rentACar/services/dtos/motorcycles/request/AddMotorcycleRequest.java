package com.tobeto.rentACar.services.dtos.motorcycles.request;

import lombok.Data;

@Data
public class AddMotorcycleRequest {
    private String plateNumber;
    private int passengerCapacity;
    private String image;
}
