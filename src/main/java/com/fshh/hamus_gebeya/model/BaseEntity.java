package com.fshh.hamus_gebeya.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fshh.hamus_gebeya.userManagement.security.SecurityUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class BaseEntity {

    @CreatedBy
    @Column(name = "created_by", nullable = false, length = 50, updatable = false)
    @JsonIgnore
    private String createdBy;

    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    private LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by", length = 50)
    @JsonIgnore
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    private LocalDateTime lastModifiedDate;

    @PrePersist
    public void prePersist() {

        Optional<String> currentUserLogin = SecurityUtils.getCurrentUserLogin();
        if (currentUserLogin != null && currentUserLogin.isPresent()){
            createdBy = currentUserLogin.get();
            lastModifiedBy = currentUserLogin.get();
        }
        else{
            createdBy = "anonymous";
            lastModifiedBy = "anonymous";
        }
        createdDate = LocalDateTime.now();
        lastModifiedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void postUpdate() {

        Optional<String> currentUserLogin = SecurityUtils.getCurrentUserLogin();

        if (currentUserLogin != null && currentUserLogin.isPresent()){
            lastModifiedBy = currentUserLogin.get();
        }
        else{
            lastModifiedBy = "anonymous";
        }
        lastModifiedDate = LocalDateTime.now();
    }
}

