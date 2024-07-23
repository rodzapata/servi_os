package com.serviparamo.api_rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder

public class EquipmentDto {
    private Long id;

    @NotBlank
    private String serialNumber;

    @NotNull
    private Date installationDate;

    @NotNull
    private Date lastMaintenanceDate;

    @NotNull
    private Long customerId;

    private String customerFullName;

    private String customerPhone;

}
