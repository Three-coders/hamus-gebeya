package com.fshh.hamus_gebeya.userManagement.service;

import com.fshh.hamus_gebeya.userManagement.model.Role;
import com.fshh.hamus_gebeya.userManagement.model.User;
import com.fshh.hamus_gebeya.userManagement.repository.RoleRepository;
import com.fshh.hamus_gebeya.userManagement.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerNewUserAccount(User user, String role) {
        Role userRole = roleRepository.findByName(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(userRole));
        return userRepository.save(user);
    }
}

