package com.tobeto.rentACar.services.dtos.brands.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandsByCustomerResponse {
    private int id;
    private String brandName;
}
