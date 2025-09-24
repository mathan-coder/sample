package com.example.TestSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    public static void main(String[] args) {
        String password = "1111";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
        String pswd =bCryptPasswordEncoder.encode(password);
        System.out.println(pswd);

    }

}
