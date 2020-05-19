package com.example.onlinestore.controller;


import com.example.onlinestore.dto.UserDto;
import com.example.onlinestore.entity.user.User;
import com.example.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<UserDto> getUser(@RequestParam(name = "id") Long id) {
        User user = userService.findById(id);
        System.out.println(user.getUsername());
        UserDto userDto = UserDto.fromUser(user);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }

}
