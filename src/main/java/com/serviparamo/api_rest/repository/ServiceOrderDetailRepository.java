package com.serviparamo.api_rest.repository;

import com.serviparamo.api_rest.entity.ServiceOrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOrderDetailRepository extends JpaRepository<ServiceOrderDetailEntity, Long> {

}
