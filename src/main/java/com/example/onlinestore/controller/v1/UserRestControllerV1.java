package com.example.onlinestore.controller.v1;

import com.example.onlinestore.dto.user.UserDto;
import com.example.onlinestore.entity.user.User;
import com.example.onlinestore.service.ImageService;
import com.example.onlinestore.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;



@RestController
@RequestMapping(value = "/api/v1/users")
@CrossOrigin
public class UserRestControllerV1 {
    private final UserService userService;

    @Autowired
    public UserRestControllerV1(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<UserDto> setAvatar(@RequestParam(value = "img", required = false) MultipartFile img,
                                             @RequestParam("user_id") Long userId) throws IOException {

        User user = userService.getById(userId);
        user.setAvatar(ImageService.saveFile(img));
        userService.update(user);

        return new ResponseEntity<>(UserDto.fromUser(user), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<UserDto> getUser(@RequestParam Long id){
        User user = userService.getById(id);
        return new ResponseEntity<>(UserDto.fromUser(user), HttpStatus.OK);
    }
}
