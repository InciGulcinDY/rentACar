package com.tobeto.rentACar.services.dtos.customers.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetAllCustomerResponse {
    private String firstName;
    private String lastName;
    private LocalDateTime birthday;
    private String InternationalId;
}
