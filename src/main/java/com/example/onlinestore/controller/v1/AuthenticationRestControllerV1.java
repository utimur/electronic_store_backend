package com.example.onlinestore.controller.v1;

import com.example.onlinestore.dto.user.AuthenticationRequestDto;
import com.example.onlinestore.dto.user.UserDto;
import com.example.onlinestore.entity.user.User;
import com.example.onlinestore.exceptions.existException.UserAlreadyExistAuthException;
import com.example.onlinestore.security.jwt.JwtAuthenticationException;
import com.example.onlinestore.security.jwt.JwtTokenProvider;
import com.example.onlinestore.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthenticationRestControllerV1 {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    @Autowired
    public AuthenticationRestControllerV1(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userService.getByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoles(), user.getId());

            Map<Object, Object> response = new HashMap<>();
            response.put("user", UserDto.fromUser(user));
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody User user) {
        if (userService.getByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistAuthException("User already exist");
        } else {
            User newUser = userService.register(user);
            return getResponseEntity(user, newUser);
        }
    }

    private ResponseEntity getResponseEntity(@RequestBody User user, User newUser) {
        String token = jwtTokenProvider.createToken(newUser.getUsername(), user.getRoles(), user.getId());

        Map<Object, Object> response = new HashMap<>();
        response.put("user", UserDto.fromUser(newUser));
        response.put("token", token);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getUserByToken(@RequestHeader("Authorization") String authHeader) {
        if(authHeader == null || authHeader.equals("")){
            System.out.println("token " + authHeader);
            throw new JwtAuthenticationException("Token is invalid");
        }
        String token = authHeader.substring(7);
        System.out.println("token " + token);

        User user = userService.getById(jwtTokenProvider.getId(token));
        return getResponseEntity(user, user);

    }
}
