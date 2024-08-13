package com.serviparamo.api_rest.dto;

import lombok.Data;

@Data
public class ProductoDTO {
    private Long id;
    private String nombre;
    private Double precio;

    // Getters y Setters
}
