package com.example.onlinestore.service.user.impl;

import com.example.onlinestore.entity.user.Role;
import com.example.onlinestore.entity.user.User;
import com.example.onlinestore.repos.user.RoleRepo;
import com.example.onlinestore.repos.user.UserRepo;
import com.example.onlinestore.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;
    private final RoleRepo roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepo userRepository, RoleRepo roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findById(new Long(1)).get();
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);

        User registeredUser = userRepository.save(user);

        log.info("IN register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }


    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username);
        log.info("IN findByUsername - user: {} found by username: {}", result, username);

        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);

        if (result == null) {
            return null;
        }
        log.warn("IN findById - no user found by id: {}", id);

        return result;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
