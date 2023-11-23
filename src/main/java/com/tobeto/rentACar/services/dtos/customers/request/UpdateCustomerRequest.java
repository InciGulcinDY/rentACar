package com.tobeto.rentACar.services.dtos.customers.request;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UpdateCustomerRequest {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDateTime birthday;
    private String InternationalId;
}
