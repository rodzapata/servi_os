package com.serviparamo.api_rest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "equipment_type")
public class EquipmentTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "equipment_type_name")
    private String equipmentTypeName;

}
