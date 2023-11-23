package com.tobeto.rentACar.services.dtos.cars.response;

import lombok.Data;

@Data
public class GetAllCarsResponse {
    private String plateNumber;
    //private String brand;
    private String model;
    private int passengerCapacity;
    private  int baggageCapacity;
    private String image;

}
