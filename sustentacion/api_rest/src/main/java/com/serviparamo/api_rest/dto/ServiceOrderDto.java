package com.serviparamo.api_rest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ServiceOrderDto {

    private Long id;
    private Long customerId;
    private Long equipmentId;
    private Date date;
    private String customerFullName;
    private String serialNumber;
    private String equipmentTypeName;
    private String brandName;
    private String refrigerantName;


    private List<ServiceOrderDetailDto> details;

    public ServiceOrderDto() {
    }
    // Getters y Setters
}
