package com.eeshania.application.services;


import com.eeshania.application.entities.User;
import com.eeshania.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    private final UserRepository userRepository;
    UserDetails userDetails;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ...

   /* public User getAuthenticatedUser() {
        final Authentication authentication = SecurityContextHolder.getContext ( ).getAuthentication ( );
        final UserDetails userDetails = (UserDetails) authentication.getPrincipal ( );


        return userRepository.findUsersByEmail (userDetails.getClass ().getName ());
    }*/
    public User getUserByEmail(String email) {
        return userRepository.findUsersByEmail(email);
    }
    public void saveUser(User user) {
        userRepository.save(user);

    }
}