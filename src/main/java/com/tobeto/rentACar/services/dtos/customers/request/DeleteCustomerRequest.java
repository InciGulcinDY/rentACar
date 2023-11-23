package com.tobeto.rentACar.services.dtos.customers.request;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class DeleteCustomerRequest {
    private int id;
    private String InternationalId;
}
