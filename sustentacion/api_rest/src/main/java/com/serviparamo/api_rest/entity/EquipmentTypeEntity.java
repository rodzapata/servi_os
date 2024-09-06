package com.serviparamo.api_rest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipmentType")
    private List<EquipmentEntity> equipments;



}
