package com.eeshania.application.repositories;


import com.eeshania.application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);


    User findUsersById(Long id);


    @Override
    void delete(User user);

    User findUsersByEmail(String email);


}
