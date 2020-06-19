package com.example.onlinestore.controller.v1;

import com.example.onlinestore.dto.user.AuthenticationRequestDto;
import com.example.onlinestore.dto.user.UserDto;
import com.example.onlinestore.entity.user.User;
import com.example.onlinestore.security.jwt.JwtAuthenticationException;
import com.example.onlinestore.security.jwt.JwtTokenProvider;
import com.example.onlinestore.service.user.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/mail")
public class MailControllerV1 {


    private final JavaMailSender emailSender;
    private final UserServiceImpl userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final BCryptPasswordEncoder passwordEncoder;


    public MailControllerV1(JavaMailSender emailSender, UserServiceImpl userService, JwtTokenProvider jwtTokenProvider, BCryptPasswordEncoder passwordEncoder) {
        this.emailSender = emailSender;
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/recovery")
    public String Recovery(@RequestParam String mail) {
        User user = userService.getByMail(mail);

        String token = jwtTokenProvider.createToken(user.getUsername(), user.getRoles(), user.getId());

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(mail);
        message.setSubject("Device store pass recovery");
        message.setText("Open link to reset password " + "http://localhost:3000/recover/"+token);

        // Send Message!
        this.emailSender.send(message);

        return "Email Sent!";
    }

    @PostMapping("/password")
    public ResponseEntity passwordRecovery(@RequestBody AuthenticationRequestDto authenticationRequestDto,
                                           @RequestHeader("Authorization") String authHeader) {

        if(authHeader == null || authHeader.equals("")){
            throw new JwtAuthenticationException("Token is invalid");
        }
        String token = authHeader.substring(7);

        User user = userService.getById(jwtTokenProvider.getId(token));

        user.setPassword(passwordEncoder.encode(authenticationRequestDto.getPassword()));
        userService.update(user);
        Map response = new HashMap();
        response.put("token", token);
        response.put("user", UserDto.fromUser(user));
        return ResponseEntity.ok(response);
    }
}
