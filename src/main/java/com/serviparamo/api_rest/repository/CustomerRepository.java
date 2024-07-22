package com.serviparamo.api_rest.repository;

import com.serviparamo.api_rest.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends
        JpaRepository<CustomerEntity, Long>,
        JpaSpecificationExecutor<CustomerEntity> {
    CustomerEntity findByEmail(String email);

}
