package com.example.demo.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.AssetService;
import com.example.demo.entity.Asset;
import com.example.demo.repository.AssetRepository;
import java.util.List;
@Service
public class AssetServiceImp implements AssetService{
private final AssertRepository assetRepo;
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