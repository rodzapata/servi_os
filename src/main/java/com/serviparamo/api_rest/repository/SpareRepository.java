package com.serviparamo.api_rest.repository;

import com.serviparamo.api_rest.entity.SpareEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SpareRepository extends
        JpaRepository<SpareEntity, Long>,
        JpaSpecificationExecutor<SpareEntity> {

    SpareEntity findBySpareName(String SpareName);

}
