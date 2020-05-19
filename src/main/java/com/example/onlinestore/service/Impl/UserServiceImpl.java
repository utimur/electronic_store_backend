package com.example.onlinestore.service.Impl;

import com.example.onlinestore.entity.user.Role;
import com.example.onlinestore.entity.user.User;
import com.example.onlinestore.repos.user.RoleRepo;
import com.example.onlinestore.repos.user.UserRepo;
import com.example.onlinestore.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public User register(User user) {
        Role role = roleRepo.findById(new Long(1)).get();
        List<Role> roles = Arrays.asList(role);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roles);

        User registredUser = userRepo.save(user);

        return user;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).get();
    }


}
