package com.example.demo.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.UserService;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
private final UserRepository assetRepo;
public AssetServiceImpl(AssetRepository assetRepo){
    this.assetRepo=assetRepo;
}
    @Override
public Asset PostData(Asset asset){
return assetRepo.save(asset);
}
@Override
public List<Asset>getAllData(){
return assetRepo.findAll();
}

@Override
public Asset getData(int id){
    return assetRepo.findById((long)id).orElseThrow(()->new ResorceNotFoundException("Asset not found"));

}
@Override
public Asset updateStatus(int id,String status){
   Asset asset=getData(id);
   asset.setStatus(status);
   return assetRepo.save(asset);
}
}