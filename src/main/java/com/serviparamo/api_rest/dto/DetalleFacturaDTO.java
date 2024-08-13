package com.serviparamo.api_rest.dto;

import lombok.Data;

@Data
public class DetalleFacturaDTO {
    private Long id;
    private ProductoDTO producto;
    private Integer cantidad;
    private Double total;

    // Getters y Setters
}
