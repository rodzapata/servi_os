package com.serviparamo.api_rest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "service_order_detail")
public class ServiceOrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "service_order_id", nullable = false)
    private ServiceOrderEntity serviceOrder;

    @ManyToOne
    @JoinColumn(name = "activity_id", nullable = false)
    private ActivityEntity activity;
/*
    @ManyToOne
    @JoinColumn(name = "equipment_id", nullable = false)
    private EquipmentEntity equipment;
*/

    private String description;
/*
    private String serialNumber;
    private String equipmentTypeName;
    private String brandName;
    private String refrigerantName;
*/
    // Getters y Setters
}
