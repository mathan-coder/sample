package com.example.TestSecurity.repository;

import com.example.TestSecurity.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users getByUsername(String username);
}
