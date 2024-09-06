package com.serviparamo.api_rest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "servi-order")

public class ServiOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "scheduled_date")
    private Date scheduledDate;

    @Column(name = "completion_date")
    private Date completionDate;

    @Column(name = "customer_authorization")
    private boolean customerAuthorization;

    @Column(name = "operational_authorization")
    private boolean operationalAuthorization;

    @Column(name = "coordinator_authorization")
    private boolean coordinatorAuthorization;

    @Column(name = "note")
    private String note;

    /*
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, updatable = false)
    private CustomerEntity customer;
*/

}
