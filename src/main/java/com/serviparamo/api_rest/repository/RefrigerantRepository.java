package com.serviparamo.api_rest.repository;

import com.serviparamo.api_rest.entity.RefrigerantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RefrigerantRepository extends
        JpaRepository<RefrigerantEntity, Long>,
        JpaSpecificationExecutor<RefrigerantEntity> {

    RefrigerantEntity findByRefrigerantName(String refrigerantName);

}
