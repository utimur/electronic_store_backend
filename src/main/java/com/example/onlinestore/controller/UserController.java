package com.example.onlinestore.controller;


import com.example.onlinestore.entity.device.Property;
import com.example.onlinestore.entity.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public ResponseEntity<User> getUser(@RequestParam Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
