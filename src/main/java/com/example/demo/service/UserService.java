package com.example.demo.service;
import com.example.demo.entity.User;

public interface UserService {
    User registerUser(User user);
    User getUser(Long id); // Added to satisfy UserServiceImpl error
}
