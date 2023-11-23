package com.tobeto.rentACar.services.dtos.vans.requests;

import lombok.Data;

@Data
public class AddVanRequest {
    private String plateNumber;
    private int passengerCapacity;
    private String image;
}
