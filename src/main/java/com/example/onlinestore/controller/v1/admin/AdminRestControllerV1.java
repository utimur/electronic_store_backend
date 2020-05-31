package com.example.onlinestore.controller.v1.admin;


import com.example.onlinestore.dto.user.UserDto;
import com.example.onlinestore.entity.user.User;
import com.example.onlinestore.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/admin")
public class AdminRestControllerV1 {

    private final UserService userService;

    public AdminRestControllerV1(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> usersDto = userService.getAll()
                .stream().map(UserDto::fromUser)
                .collect(Collectors.toList());

        return new ResponseEntity<>(usersDto,HttpStatus.OK);
    }

}
