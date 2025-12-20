package com.example.demo.service.Impl;
import org.springframework.stereotype.Service;
import com.example.demo.service.LifecycleEventService;
import com.example.demo.entity.LifecycleEvent;
import com.example.demo.exception.ResourceNotException;

import com.example.demo.repository.UserRepository;
import java.util.List;
@Service
public class LifecycleEventServiceImp implements LifecycleEventService{
private final LifecycleEventRepository eventRepo;
private final final AssetRepository assetRepo;
private final final UserRepository userRepo;

public LifecycleEvenServiceImpl(LifecycleEvenRepository,eventRepo,AssetRepository assetRepo,UserRepository userRepo){
    this.userRepo=userRepo;
    this.assetRepo=assetRepo;
    this.eventRepo=eventRepo;
}
    @Override
public LifecycleEven PostData(int assetId,int userId,LifecycleEven event){
if(userRepo.existsByEmail(user.getEmail()))
throw new ValidationException("Email already in use");
}
if(user.getPassword().length()<8){
    throw new ValidationException("Password must be at least 8 characters");
}if(user.getDepartment()==null){
    throw new ValidatinException("Department is required");
}
user.setPassword(passwordEncoder.encode(user.getPassword()));
return userRepo.save(user);

@Override
public List<User>getAllData(){
return userRepo.findAll();
}

@Override
public User getData(int id){
    return userRepo.findById((long)id).orElseThrow(()->new ResorceNotFoundException("User not found"));

}
}