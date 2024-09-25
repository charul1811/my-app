package com.eeshania.application.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Role {

    private String role;
    @Getter
    @Setter
    @Id
    private Long id;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users=new HashSet<>();

}
