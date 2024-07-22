package com.serviparamo.api_rest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "usuario")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "born_date")
    private Date bornDate;

    @Column(name = "state")
    private Long state;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "password")
    private String password;
    /*
    @Column(name = "rol_id")
    private Long rolId;
    */

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false, updatable = false)
    private RolEntity rol;

}
