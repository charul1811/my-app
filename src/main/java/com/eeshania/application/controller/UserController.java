package com.eeshania.application.controller;


import com.eeshania.application.entities.User;
import com.eeshania.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    private final UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("Email already in use");
        }
        
        // Here you would typically hash the password before saving
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {


        if (userRepository.existsByEmail(user.getEmail()) && user.getPassword().equals(user.getPassword())) {
            // Ideally, you should use a hashed password comparison
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status( HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
    @GetMapping
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok(userRepository.findAll());
    }

}
