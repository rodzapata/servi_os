package com.serviparamo.api_rest.entity;

import jakarta.persistence.*;
import lombok.Data;

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

}
