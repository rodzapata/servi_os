package com.serviparamo.api_rest.repository;

import com.serviparamo.api_rest.entity.TechnicianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends
        JpaRepository<TechnicianEntity, Long>,
        JpaSpecificationExecutor<TechnicianEntity> {
    TechnicianEntity findByEmail(String email);

}
