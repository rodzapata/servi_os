package com.serviparamo.api_rest.repository;

import com.serviparamo.api_rest.entity.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Long> {
    EquipmentEntity findBySerialNumber(String serialNumber);
}


/*
@Repository
public interface EquipmentRepository extends
        JpaRepository<EquipmentEntity, Long>,
        JpaSpecificationExecutor<EquipmentEntity> {

    EquipmentEntity findBySerialNumber(String serialNumber);
}
*/
