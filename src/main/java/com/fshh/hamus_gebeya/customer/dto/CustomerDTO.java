package com.fshh.hamus_gebeya.customer.dto;

import com.fshh.hamus_gebeya.customer.model.enumeration.CustomerStatus;
import com.fshh.hamus_gebeya.model.BaseEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class CustomerDTO {

    private Long id;

    @NotBlank(message = "First name is mandatory")
    @Size(max = 50)
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(max = 50)
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Size(max = 20)
    private String phoneNumber;

    @NotBlank(message = "Address is mandatory")
    @Size(max = 255)
    private String address;

    private Double latitude;
    private Double longitude;

    private CustomerStatus status;
    private String remark;

    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
    // Getters and Setters
}

