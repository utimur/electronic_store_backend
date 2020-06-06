package com.example.onlinestore.dto.user;

import com.example.onlinestore.entity.user.Role;
import com.example.onlinestore.entity.user.User;
import com.example.onlinestore.service.ImageService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Long id;
    private String username;
    private String mail;
    private String phoneNumber;
    private String avatar;
    private List<Role> roles;

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
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setRoles(user.getRoles());

        if(user.getAvatar() != null) {
            String img = ImageService.IMAGE_PATH + user.getAvatar();
            File imgFile = new File(img);
            if (imgFile.exists()) {
                userDto.setAvatar(ImageService.encodeFileToBase64Binary(imgFile));
            }
        }


        return userDto;
    }
}