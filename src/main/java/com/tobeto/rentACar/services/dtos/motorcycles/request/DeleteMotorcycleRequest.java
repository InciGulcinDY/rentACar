package com.tobeto.rentACar.services.dtos.motorcycles.request;

import lombok.Data;

@Data
public class DeleteMotorcycleRequest {
    private int id;
    private String plateNumber;
}
