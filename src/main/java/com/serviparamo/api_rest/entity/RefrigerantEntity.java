package com.serviparamo.api_rest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "refrigerant")

public class RefrigerantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "refrigerant_name")
    private String refrigerantName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "refrigerant")
    private List<EquipmentEntity> equipments;

}
