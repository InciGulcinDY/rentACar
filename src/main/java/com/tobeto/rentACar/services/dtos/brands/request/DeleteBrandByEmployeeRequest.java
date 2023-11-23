package com.tobeto.rentACar.services.dtos.brands.request;

import lombok.Data;

@Data
public class DeleteBrandByEmployeeRequest {
    private int id;
    private String brandName;
}
