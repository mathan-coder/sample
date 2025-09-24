package com.example.TestSecurity.service;

import com.example.TestSecurity.Model.Users;
import com.example.TestSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);



    public void createUser(@RequestBody Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
         repo.save(user);
    }
}
