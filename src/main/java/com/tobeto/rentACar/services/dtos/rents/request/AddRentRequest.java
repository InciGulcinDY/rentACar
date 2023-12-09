package com.tobeto.rentACar.services.dtos.rents.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentRequest {
    @NotNull
    private int vehicleId;

    @NotNull
    private int customerId;

    @NotNull
    private LocalDateTime deliverDateToCustomer;

    @NotNull
    private LocalDateTime returnDate;

    @NotNull
    private Boolean isRentedWithChildSeat;

    @NotNull
    private int personnelId;
}
