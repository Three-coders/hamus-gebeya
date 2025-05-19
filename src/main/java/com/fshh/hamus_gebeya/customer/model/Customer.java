package com.fshh.hamus_gebeya.customer.model;

import com.fshh.hamus_gebeya.customer.model.enumeration.CustomerStatus;
import com.fshh.hamus_gebeya.model.BaseEntity;
import com.fshh.hamus_gebeya.userManagement.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is mandatory")
    @Size(max = 50)
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(max = 50)
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Size(max = 20)
    private String phoneNumber;

    @NotBlank(message = "Address is mandatory")
    @Size(max = 255)
    private String address;

    private Double latitude;
    private Double longitude;

    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    private String remark;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
