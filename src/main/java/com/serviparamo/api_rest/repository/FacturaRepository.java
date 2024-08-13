package com.serviparamo.api_rest.repository;

import com.serviparamo.api_rest.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

}
