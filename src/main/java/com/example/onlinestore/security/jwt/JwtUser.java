package com.example.onlinestore.security.jwt;

import com.example.onlinestore.entity.user.Basket;
import com.example.onlinestore.entity.user.Favourite;
import com.example.onlinestore.entity.user.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class JwtUser implements UserDetails {

    private Long id;
    private String password;
    private String username;
    private String mail;
    private String phoneNumber;
    private String avatar;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean enabled;
    private List<Order> orders;
    private List<Basket> baskets;
    private List<Favourite> favourites;

    public JwtUser(Long id, String password, String username, String mail, String phoneNumber, String avatar, Collection<? extends GrantedAuthority> authorities, boolean enabled, List<Order> orders, List<Basket> baskets, List<Favourite> favourites) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.authorities = authorities;
        this.enabled = enabled;
        this.orders = orders;
        this.baskets = baskets;
        this.favourites = favourites;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }


    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
