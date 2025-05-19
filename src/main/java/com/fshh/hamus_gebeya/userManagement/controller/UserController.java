package com.fshh.hamus_gebeya.userManagement.controller;

import com.fshh.hamus_gebeya.userManagement.model.User;
import com.fshh.hamus_gebeya.userManagement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user, @RequestParam String role) {
        User registeredUser = userService.registerNewUserAccount(user, role);
        return ResponseEntity.ok(registeredUser);
    }
}
