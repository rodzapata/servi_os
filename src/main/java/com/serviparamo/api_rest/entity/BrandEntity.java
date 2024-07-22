package com.serviparamo.api_rest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "brand")
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand_name")
    private String brandName;

}

