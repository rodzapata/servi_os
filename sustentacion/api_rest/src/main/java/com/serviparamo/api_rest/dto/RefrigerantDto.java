package com.serviparamo.api_rest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder

public class RefrigerantDto {
    private Long id;

    @NotBlank
    private String refrigerantName;

}
