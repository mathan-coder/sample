package com.example.TestSecurity.controller;

import com.example.TestSecurity.Model.Users;
import com.example.TestSecurity.repository.UserRepository;
import com.example.TestSecurity.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/admin/add")
    public void createUser(@RequestBody Users user) {
       userService.createUser(user);
    }

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        return "Hello World"+request.getSession().getId();
    }



}
