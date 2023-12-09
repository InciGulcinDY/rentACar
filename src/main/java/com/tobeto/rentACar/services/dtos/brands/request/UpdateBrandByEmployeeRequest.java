package com.tobeto.rentACar.services.dtos.brands.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandByEmployeeRequest {
    @NotBlank
    @Length(max = 15, message = "Brand can not have more than 15 characters!")
    private String brandName;
}
