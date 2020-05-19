package com.example.onlinestore.security.jwt;

import com.example.onlinestore.entity.user.Role;
import com.example.onlinestore.entity.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {
    public JwtUserFactory() {

    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getPassword(),
                user.getUsername(),
                user.getMail(),
                user.getPhoneNumber(),
                user.getAvatar(),
                mapToGrantedAuhorities(user.getRoles()),
                true,
                user.getOrders(),
                user.getBaskets(),
                user.getFavourites()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuhorities(List<Role> roles){
        return roles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList()) ;
    }
}
