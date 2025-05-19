package com.fshh.hamus_gebeya.userManagement.repository;

import com.fshh.hamus_gebeya.userManagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
