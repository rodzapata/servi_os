package com.serviparamo.api_rest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "equipment")

public class EquipmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "installation_date")
    private Date installationDate;

    @Column(name = "last_maintenance_date")
    private Date lastMaintenanceDate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, updatable = false)
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "equipment_type_id", nullable = false, updatable = false)
    private EquipmentTypeEntity equipmentType;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false, updatable = false)
    private BrandEntity brand;

    @ManyToOne
    @JoinColumn(name = "refrigerant_id", nullable = false, updatable = false)
    private RefrigerantEntity refrigerant;

}
