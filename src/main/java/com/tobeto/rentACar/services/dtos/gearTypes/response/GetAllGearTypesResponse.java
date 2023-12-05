package com.tobeto.rentACar.services.dtos.gearTypes.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllGearTypesResponse {
    private int id;
    private String gearTypeDef;
}
