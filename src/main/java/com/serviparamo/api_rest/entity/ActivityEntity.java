package com.serviparamo.api_rest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "activity")
public class ActivityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "activity_name")
    private String activityName;
/*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activity")
    private List<PerformedActivityEntity> performedActivitys;
*/

}

