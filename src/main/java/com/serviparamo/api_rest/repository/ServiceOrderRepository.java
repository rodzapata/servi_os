package com.serviparamo.api_rest.repository;

import com.serviparamo.api_rest.entity.ServiceOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrderEntity, Long> {

}

