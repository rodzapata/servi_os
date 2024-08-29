package com.serviparamo.api_rest.repository;

import com.serviparamo.api_rest.entity.MaintenanceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceTypeRepository extends JpaRepository<MaintenanceTypeEntity, Long> {
    MaintenanceTypeEntity findByMaintenanceTypeName(String maintenanceTypeName);
}

