package com.example.onlinestore.dto;

import com.example.onlinestore.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Long id;
    private String username;
    private String mail;
    private String phoneNumber;
    private String avatar;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setMail(mail);
        user.setAvatar(avatar);
        user.setPhoneNumber(phoneNumber);
        return user;
    }

    public static UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setMail(user.getMail());
        userDto.setAvatar(user.getAvatar());
        userDto.setPhoneNumber(user.getPhoneNumber());

        return userDto;
    }
}