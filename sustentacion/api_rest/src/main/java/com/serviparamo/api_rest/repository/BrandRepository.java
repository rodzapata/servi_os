package com.serviparamo.api_rest.repository;

import com.serviparamo.api_rest.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends
        JpaRepository<BrandEntity, Long>,
        JpaSpecificationExecutor<BrandEntity> {

        BrandEntity findByBrandName(String brandName);

}
