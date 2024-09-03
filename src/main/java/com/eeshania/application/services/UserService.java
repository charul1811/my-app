package com.eeshania.application.services;

import com.eeshania.application.entities.User;
import com.eeshania.application.repositories.UserRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@BrowserCallable
@AnonymousAllowed
@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void save(User user) {
        userRepository.save ( user );
    }

    public String getUserByEmail(User user) {


        /*if (userRepository.existsByEmail ( user.getEmail ( ) ) && user.getPassword ( ).equals ( user.getPassword ( ) )) {
            // Ideally, you should use a hashed password comparison
            return ResponseEntity.ok ( "Login successful" );
        } else {
            return ResponseEntity.badRequest (  ).body ( "Invalid credentials" );
        }*/


        try {
            User user1= userRepository.findUsersByEmail ( user.getEmail ( ) );
            if (user1.getPassword ( ).equals ( user.getPassword ( ) )) {
                // Ideally, you should use a hashed password comparison
                return  ( "Login successful" );
            } else {
                return ( "Invalid credentials" );
            }
        } catch (Exception e) {
            return ( "User not found" );
        }
    }
}
