package com.tobeto.rentACar.services.dtos.customers.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerByFirstNameStartingWithResponse {
    private String firstName;
    private String lastName;
    private LocalDateTime birthday;
    private String InternationalId;
}
