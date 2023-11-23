package com.tobeto.rentACar.services.dtos.cars.request;

import lombok.Data;

@Data
public class DeleteCarRequest {
    private int id;
    private String plateNumber;
}
