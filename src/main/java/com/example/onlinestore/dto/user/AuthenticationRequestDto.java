package com.example.onlinestore.dto.user;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;
}