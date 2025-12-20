package com.example.demo.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.AssetService;
import com.example.demo.entity.Asset;
import com.example.demo.repository.AssetRepository;
import java.util.List;
@Service
public class AssetServiceImp implements AssetService{
    @Autowired AssetRepository stude;
    @Override
public StudentEntity PostData(StudentEntity stu){
return student.save(stu);
}
@Override
public List<StudentEntity>getAllData(){
return student.findAll();
}
@Override
public String DeleteData(int id){
    student.deleteById(id);
    return "Deleted Successfully";
}
@Override
public StudentEntity getData(int id){
    return student.findById(id).orElse(null);
}
@Override
public StudentEntity updateData(int id,StudentEntity entity){
    if(student.existsById(id)){
        entity.setId(id);
        return student.save(entity);
}
    return null;
}
}