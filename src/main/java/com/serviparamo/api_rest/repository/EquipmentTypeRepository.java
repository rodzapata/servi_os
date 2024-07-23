package com.serviparamo.api_rest.repository;

import com.serviparamo.api_rest.entity.EquipmentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentTypeRepository extends
        JpaRepository<EquipmentTypeEntity, Long>,
        JpaSpecificationExecutor<EquipmentTypeEntity> {

    EquipmentTypeEntity findByEquipmentTypeName(String equipmentTypeName);

}
