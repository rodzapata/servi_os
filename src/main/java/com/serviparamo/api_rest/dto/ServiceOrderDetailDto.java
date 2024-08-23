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
    private Long equipmentId;
    private String description;
    private String serialNumber;
    private String equipmentTypeName;
    private String brandName;
    private String refrigerantName;

    public ServiceOrderDetailDto(){

    }
    // Getters y Setters
}
