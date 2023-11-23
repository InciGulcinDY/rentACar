package com.tobeto.rentACar.services.dtos.cars.request;

import lombok.Data;

@Data
public class UpdateCarRequest {
    private int id;
    private String plateNumber;
    private int baggageCapacity;
    private String image;
    private int passengerCapacity;
}
