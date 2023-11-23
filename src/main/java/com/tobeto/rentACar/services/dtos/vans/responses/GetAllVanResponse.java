package com.tobeto.rentACar.services.dtos.vans.responses;

import lombok.Data;

@Data
public class GetAllVanResponse {
    private String plateNumber;
    private int passengerCapacity;
    private String image;
}
