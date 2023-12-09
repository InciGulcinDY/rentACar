package com.tobeto.rentACar.services.dtos.branches.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBranchRequest {
    @NotBlank
    private String branchName;

    @NotNull
    private int cityId;
}
