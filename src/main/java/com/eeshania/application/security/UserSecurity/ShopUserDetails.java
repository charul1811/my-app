package com.eeshania.application.security.UserSecurity;

import com.eeshania.application.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ShopUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;
    private final String username;
    private final String password;
    private final List<GrantedAuthority> authorities;

    public ShopUserDetails(String username, String password, List<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static ShopUserDetails BuildUser(User user) {
    List<GrantedAuthority> authorities = user.getRoles()
            .stream()
            .map(role -> new SimpleGrantedAuthority(role.getRole()))
            .collect(Collectors.toList());

    return new ShopUserDetails(
            user.getEmail(),
            user.getPassword(),
            authorities
    );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}
