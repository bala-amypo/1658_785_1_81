package com.example.demo.service;

import com.example.demo.entity.LiecycleEvent;
import java.util.List;
public interface LiecycleEventService{
LiecycleEvent PostData(Long assetId,Long userId,LiecycleEvent event);
List<LiecycleEvent>getval(Long assetId);
LiecycleEvent getdata(Long id);
}