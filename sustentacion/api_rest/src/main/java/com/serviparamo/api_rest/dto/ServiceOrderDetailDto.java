package com.serviparamo.api_rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ServiceOrderDetailDto {

    private Long id;
    private Long activityId;
    private String description;

    public ServiceOrderDetailDto(){

    }
    // Getters y Setters
}
