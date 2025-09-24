package com.example.TestSecurity.service;

import com.example.TestSecurity.Model.Users;
import com.example.TestSecurity.Model.UserPrincipal;
import com.example.TestSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user=repo.getByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("Username not found");
        }
        return new UserPrincipal(user);

    }
}
