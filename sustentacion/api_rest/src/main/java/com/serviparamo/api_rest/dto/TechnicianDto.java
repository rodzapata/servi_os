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

public class TechnicianDto {
    private Long id;

    @NotBlank
    private String fullName;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @NotNull
    private Date hireDate;

}
