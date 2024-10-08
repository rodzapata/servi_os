package com.serviparamo.api_rest.repository;

import com.serviparamo.api_rest.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRespository extends
        JpaRepository<RolEntity, Long>,
        JpaSpecificationExecutor<RolEntity> {
}

