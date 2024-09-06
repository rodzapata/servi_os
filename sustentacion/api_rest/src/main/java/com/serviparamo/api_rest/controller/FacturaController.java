package com.serviparamo.api_rest.controller;

import com.serviparamo.api_rest.dto.FacturaDTO;
import com.serviparamo.api_rest.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/factura")

public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @PostMapping
    public ResponseEntity<FacturaDTO> createFactura(@RequestBody FacturaDTO facturaDTO) {
        FacturaDTO createdFactura = facturaService.createFactura(facturaDTO);
        return ResponseEntity.ok(createdFactura);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDTO> getFacturaById(@PathVariable Long id) {
        FacturaDTO facturaDTO = facturaService.findById(id);
        return ResponseEntity.ok(facturaDTO);
    }

    @GetMapping
    public ResponseEntity<List<FacturaDTO>> getAllFacturas() {
        List<FacturaDTO> facturas = facturaService.findAll();
        return ResponseEntity.ok(facturas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFactura(@PathVariable Long id) {
        facturaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
