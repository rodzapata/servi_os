package com.serviparamo.api_rest.repository;

import com.serviparamo.api_rest.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
