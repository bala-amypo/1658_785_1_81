package com.example.demo.controller;

import org.springframework.web.bind.annotation.AssetController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.service.StudentService;
import com.example.demo.entity.StudentEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;


import java.util.List;
@RestController

public class AssetController{
@Autowired StudentService ser;
@PostMapping("/post")
public StudentEntity sendData(@RequestBody StudentEntity stu){
    return ser.PostData(stu);
}
@GetMapping("/get")
public List<StudentEntity>getval(){
    return ser.getAllData();
}
@DeleteMapping("/delete/{id}")
public String deleteval(@PathVariable int id){
    return ser.DeleteData(id);
}
@GetMapping("/getid/{id}")
public StudentEntity getdata(@PathVariable int id){
    return ser.getData(id);
}
@PutMapping("/putid/{id}")
public StudentEntity putval(@PathVariable int id,@RequestBody StudentEntity entity){
    return ser.updateData(id,entity);
}
}