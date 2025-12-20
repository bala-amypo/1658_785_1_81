package com.example.demo.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.UserService;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotException;

import com.example.demo.repository.UserRepository;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
private final UserRepository userRepo;
private final PasswordEncoder passwordEncoder;
public UserServiceImpl(UserRepository,userRepo,PasswordEncoder passwordEncoder){
    this.userRepo=userRepo;
    this.passwordEncoder=passwordEncoder;
}
    @Override
public User PostData(User user){
if(userRepo.existsByEmail(user.getEmail()))
}
@Override
public List<User>getAllData(){
return userRepo.findAll();
}

@Override
public User getData(int id){
    return userRepo.findById((long)id).orElseThrow(()->new ResorceNotFoundException("Asset not found"));

}
@Override
public Asset updateStatus(int id,String status){
   Asset asset=getData(id);
   asset.setStatus(status);
   return assetRepo.save(asset);
}
}