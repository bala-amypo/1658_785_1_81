package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {

    User saveUser(User user);           // registerUser equivalent
    List<User> getAllUsers();
    User getUser(Long id);              // required by UserController
}
