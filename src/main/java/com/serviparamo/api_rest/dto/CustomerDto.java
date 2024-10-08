package com.serviparamo.api_rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder

public class CustomerDto {
    private Long id;

    @NotBlank
    private String fullName;

    @NotNull
    private Date bornDate;

   // @NotNull
    private Long state;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    //@NotBlank
    private String address;

    //@NotBlank
    private String city;

}
