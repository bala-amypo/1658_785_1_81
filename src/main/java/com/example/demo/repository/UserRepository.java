package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Fix for CustomUserDetailsService
    Optional<User> findByUsername(String username);

    // FIX FOR UserServiceImpl: Add this line
    boolean existsByEmail(String email);
    
    // Recommended: Also add this to check for duplicate usernames during registration
    boolean existsByUsername(String username);
}