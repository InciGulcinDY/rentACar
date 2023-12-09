package com.tobeto.rentACar.services.dtos.personnel.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePersonnelRequest {
    @NotBlank
    @Length(max = 20,message = "Firstname can not have more than 20 characters!")
    private String firstName;

    @NotBlank
    @Length(max = 50,message = "Lastname can not have more than 50 characters!")
    private String lastName;

    @NotNull
    private LocalDateTime birthday;

    @NotBlank
    @Length(max = 11,message = "International Id can not have more than 11 characters!")
    private String InternationalId;

    @NotNull
    @Positive(message = "Value can not be negative!")
    private int companyId;

    @NotNull
    @Positive(message = "Value can not be negative!")
    private int branchId;
}
