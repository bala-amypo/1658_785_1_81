package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;
public interface UserService{
User PostData(User user);
List<User>getval();
User getdata(Long id);
}