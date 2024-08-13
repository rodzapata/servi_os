package com.serviparamo.api_rest.service;

import com.serviparamo.api_rest.dto.DetalleFacturaDTO;
import com.serviparamo.api_rest.dto.FacturaDTO;
import com.serviparamo.api_rest.dto.ProductoDTO;
import com.serviparamo.api_rest.entity.DetalleFactura;
import com.serviparamo.api_rest.entity.Factura;
import com.serviparamo.api_rest.entity.Producto;
import com.serviparamo.api_rest.repository.FacturaRepository;
import com.serviparamo.api_rest.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Transactional
    public FacturaDTO createFactura(FacturaDTO facturaDTO) {
        Factura factura = new Factura();
        factura.setCliente(facturaDTO.getCliente());
        factura.setFecha(facturaDTO.getFecha());

        List<DetalleFactura> detalles = facturaDTO.getDetalles().stream().map(detalleDTO -> {
            DetalleFactura detalle = new DetalleFactura();
            Producto producto = productoRepository.findById(detalleDTO.getProducto().getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            detalle.setProducto(producto);
            detalle.setCantidad(detalleDTO.getCantidad());
            detalle.setTotal(detalleDTO.getCantidad() * producto.getPrecio());
            detalle.setFactura(factura);
            return detalle;
        }).collect(Collectors.toList());

        factura.setDetalles(detalles);
        factura.setTotal(detalles.stream().mapToDouble(DetalleFactura::getTotal).sum());

        facturaRepository.save(factura);

        facturaDTO.setId(factura.getId());
        facturaDTO.setTotal(factura.getTotal());
        return facturaDTO;
    }

    public FacturaDTO findById(Long id) {
        Factura factura = facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        return convertToDTO(factura);
    }

    public List<FacturaDTO> findAll() {
        return facturaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteById(Long id) {
        facturaRepository.deleteById(id);
    }

    private FacturaDTO convertToDTO(Factura factura) {
        FacturaDTO facturaDTO = new FacturaDTO();
        facturaDTO.setId(factura.getId());
        facturaDTO.setCliente(factura.getCliente());
        facturaDTO.setFecha(factura.getFecha());
        facturaDTO.setTotal(factura.getTotal());

        List<DetalleFacturaDTO> detallesDTO = factura.getDetalles().stream().map(detalle -> {
            DetalleFacturaDTO detalleDTO = new DetalleFacturaDTO();
            detalleDTO.setId(detalle.getId());

            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setId(detalle.getProducto().getId());
            productoDTO.setNombre(detalle.getProducto().getNombre());
            productoDTO.setPrecio(detalle.getProducto().getPrecio());

            detalleDTO.setProducto(productoDTO);
            detalleDTO.setCantidad(detalle.getCantidad());
            detalleDTO.setTotal(detalle.getTotal());
            return detalleDTO;
        }).collect(Collectors.toList());

        facturaDTO.setDetalles(detallesDTO);
        return facturaDTO;
    }

}
