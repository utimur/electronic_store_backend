package com.example.onlinestore.controller.v1.admin;


import com.example.onlinestore.entity.device.DeviceType;
import com.example.onlinestore.exceptions.notFoundException.DeviceTypeNotFoundException;
import com.example.onlinestore.service.device.DeviceService;
import com.example.onlinestore.service.device.DeviceTypeService;
import com.example.onlinestore.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/admin/")
public class AdminRestControllerV1 {





}
