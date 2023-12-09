package com.tobeto.rentACar.services.dtos.vans.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVanRequest {
    @NotBlank
    @Length(max = 10, min=6, message = "Plate can only be between 6-10 characters!")
    private String plateNumber;

    @NotNull
    @Positive(message = "Value can not be negative!")
    @Max(value = 5, message = "Baggage capacity can be maximum 5")
    private int baggageCapacity;

    @NotBlank
    private String image;

    @NotNull
    @Min(value = 1, message = "Passenger Capacity can not be bellow 1 passenger!")
    private int passengerCapacity;

    @NotNull
    @Min(value = 18, message = "Driver can not be under18 years of age!")
    private int driverAgeLimit;

    @NotNull
    @Positive(message = "Value can not be negative!")
    private int driverExperienceReqLimit;

    @NotNull
    private int manufacturedYear;

    @NotNull
    private LocalDateTime trafficPermitLicenceDate;

    @NotNull
    private int colorId;

    @NotNull
    private int modelId;

    @NotNull
    private int gearTypeId;

    @NotNull
    private int energyTypeId;

    @NotNull
    private int driverLicenceReqTypeId;
}
