package com.tobeto.rentACar.services.dtos.vans.requests;

import lombok.Data;

@Data
public class UpdateVanRequest {
    private int id;
    private String plateNumber;
    private int passengerCapacity;
    private String image;
}
