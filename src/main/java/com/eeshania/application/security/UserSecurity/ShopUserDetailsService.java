package com.eeshania.application.security.UserSecurity;

import com.eeshania.application.entities.User;
import com.eeshania.application.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShopUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public ShopUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user= Optional.ofNullable(userRepository.findUsersByEmail(email))
                .orElseThrow(()->new UsernameNotFoundException("User not found with email: "+email));

        return ShopUserDetails.BuildUser(user);
    }
}
