package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);           // for registration
    List<User> getAllUsers();
    User getUser(Long id);
}
