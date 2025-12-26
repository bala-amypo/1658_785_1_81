package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUser(Long id);

    default User registerUser(User user) {
        return saveUser(user);
    }
}
