package com.serviparamo.api_rest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder

public class MaintenanceTypeDto {
    private Long id;

    @NotBlank
    private String maintenanceTypeName;

}

