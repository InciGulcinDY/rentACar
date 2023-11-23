package com.tobeto.rentACar.services.dtos.customers.request;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AddCustomerRequest {
    private String firstName;
    private String lastName;
    private LocalDateTime birthday;
    private String InternationalId;
}
