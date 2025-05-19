package com.fshh.hamus_gebeya.userManagement.repository;

import com.fshh.hamus_gebeya.userManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
