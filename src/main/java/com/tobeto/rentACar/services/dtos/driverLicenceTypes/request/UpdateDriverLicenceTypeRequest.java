package com.tobeto.rentACar.services.dtos.driverLicenceTypes.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDriverLicenceTypeRequest {
    @NotBlank
    private String driverLicenceTypeDef;
}
