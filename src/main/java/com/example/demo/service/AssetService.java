package com.example.demo.service;

import com.example.demo.entity.Asset;
import java.util.List;
public interface AssetService{
Asset PostData(Asset asset);
List<Asset>getval();
Asset getData(int id);
StudentEntity updateData(int id,StudentEntity entity);
}