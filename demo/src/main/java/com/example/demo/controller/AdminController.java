package com.example.demo.controller;

import com.example.demo.AdminService;
import com.example.demo.model.Admin;
import com.example.demo.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/addUser")
    @CrossOrigin(origins = "http://localhost:5173")
    public Admin addUser(@RequestBody Admin user) {

        return adminService.addUser(user);
    }

    @PostMapping("/loginUser")
    @CrossOrigin(origins = "http://localhost:5173")
    public Boolean loginUser(@RequestBody LoginRequest loginRequest) {
        return adminService.loginUser(loginRequest);
    }
}
