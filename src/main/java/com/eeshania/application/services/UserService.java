package com.eeshania.application.services;

import com.eeshania.application.entities.User;
import com.eeshania.application.repositories.UserRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.springframework.beans.factory.annotation.Autowired;
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
        userRepository.save(user);
    }
}
