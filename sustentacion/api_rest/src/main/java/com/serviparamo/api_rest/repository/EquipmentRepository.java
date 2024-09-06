package com.serviparamo.api_rest.repository;

import com.serviparamo.api_rest.dto.EquipmentDto;
import com.serviparamo.api_rest.entity.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Long> {
    EquipmentEntity findBySerialNumber(String serialNumber);
    List<EquipmentEntity> findByCustomerId(Long customerId);

    // Consulta personalizada usando JPQL
    /*
    @Query("SELECT e FROM EquipmentEntity e WHERE e.customerId = :customerId")
    List<EquipmentEntity> findByCustomerId(@Param("customerId") Long customerId);
    */
}


/*
@Repository
public interface EquipmentRepository extends
        JpaRepository<EquipmentEntity, Long>,
        JpaSpecificationExecutor<EquipmentEntity> {

    EquipmentEntity findBySerialNumber(String serialNumber);
}
*/
