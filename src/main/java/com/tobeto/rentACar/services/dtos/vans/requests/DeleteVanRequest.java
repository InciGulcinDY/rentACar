package com.tobeto.rentACar.services.dtos.vans.requests;

import lombok.Data;

@Data
public class DeleteVanRequest {
    private int id;
    private String plateNumber;
}
