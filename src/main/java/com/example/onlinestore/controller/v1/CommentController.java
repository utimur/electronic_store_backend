package com.example.onlinestore.controller.v1;


import com.example.onlinestore.dto.device.CommentDto;
import com.example.onlinestore.entity.device.Comment;
import com.example.onlinestore.entity.device.Device;
import com.example.onlinestore.entity.user.User;
import com.example.onlinestore.exceptions.notFoundException.DeviceNotFoundException;
import com.example.onlinestore.service.device.CommentService;
import com.example.onlinestore.service.device.DeviceService;
import com.example.onlinestore.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/comments")
@CrossOrigin
public class CommentController {

    private final CommentService commentService;
    private final DeviceService deviceService;
    private final UserService userService;

    public CommentController(CommentService commentService, DeviceService deviceService, UserService userService) {
        this.commentService = commentService;
        this.deviceService = deviceService;
        this.userService = userService;
    }


    @PostMapping("/add")
    public ResponseEntity addPost(@RequestBody Comment comment) throws DeviceNotFoundException {
        System.out.println(comment.toString());
        User user = userService.getById(comment.getUser().getId());
        Device device = deviceService.getById(comment.getDevice().getId());
        comment.setUser(user);
        comment.setDevice(device);
        device.setRating((device.getRating()+comment.getRating()) / (device.getComments().size()+1));
        return ResponseEntity.ok(CommentDto.fromComment(commentService.save(comment)));
    }

    @GetMapping
    public ResponseEntity getByDeviceId(@RequestParam("device_id") Long deviceId) {
        return ResponseEntity.ok(commentService.getByDeviceId(deviceId).stream()
        .map(CommentDto::fromComment).collect(Collectors.toList()));
    }
}
