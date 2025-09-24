package com.example.TestSecurity.controller;


import com.example.TestSecurity.Model.Users;
import com.example.TestSecurity.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authManager;

    @Autowired 
    JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Users user) {
        try{
            Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            UserDetails userDetails =(UserDetails) authentication.getPrincipal();
            String token = jwtUtil.generateJwtToken(userDetails);
            return ResponseEntity.ok(Map.of("token",token));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message",e.getMessage()));
        }
    }


}
