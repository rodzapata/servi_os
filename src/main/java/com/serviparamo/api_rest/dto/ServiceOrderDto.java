package com.serviparamo.api_rest.dto;

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
    private Date date;
    private String customerFullName;

    private List<ServiceOrderDetailDto> details;

    public ServiceOrderDto() {
    }
    // Getters y Setters
}
