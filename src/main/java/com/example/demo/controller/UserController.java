package com.example.demo.controller;

import org.springframework.web.bind.annotation.UserController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.UserService;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UserController{
    private final UserService userService;
    public UserController(UserService userService){
    this.userService=userService;
@PostMapping("/register")
public User sendData(@RequestBody RegisterRequest request){
    return assetService.CreateAsset(asset);
}
@GetMapping("/get")
public List<Asset>getval(){
    return assetService.getAllAsset();
}

@GetMapping("/getid/{id}")
public Asset getdata(@PathVariable Long id){
    return assetService.getAsset(id);
}
@PutMapping("/putid/{id}")
public Asset putval(@PathVariable Long id,@RequestBody String status){
    return assetService.updateStatus(id,status);
}
}