package com.serviparamo.api_rest.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class FacturaDTO {
    private Long id;
    private String cliente;
    private Date fecha;
    private List<DetalleFacturaDTO> detalles;
    private Double total;

    // Getters y Setters
}
