package com.example.demo.controller;

import org.springframework.web.bind.annotation.DisposalRecordController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.DisposalRecordService;
import com.example.demo.entity.DisposalRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
@RestController
@RequestMapping("/api/disposals")
public class DisposalRecordController{
    private final DisposalRecordService disposalService;
    public UserController(UserService userService){
    this.userService=userService;
    }
@PostMapping("/register")
public User sendData(@RequestBody RegisterRequest request ){
    User user=new User();
  user.setFullName(request.getFullName());
  user.setPassword(request.getPassword());
}
@GetMapping("/get")
public List<User>getval(){
    return UserService.getAllUsers();
}

@GetMapping("/getid/{id}")
public User getdata(@PathVariable Long id){
    return UserService.getUser(id);
}
}