package com.example.demo.service.impl;

import com.example.demo.entity.LifecycleEvent;
import com.example.demo.repository.LifecycleEventRepository;
import com.example.demo.service.LifecycleEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LifecycleEventServiceImpl implements LifecycleEventService {

    private final LifecycleEventRepository repository;

    public LifecycleEventServiceImpl(LifecycleEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public LifecycleEvent save(LifecycleEvent event) {
        return repository.save(event);
    }

    @Override
    public List<LifecycleEvent> getAll() {
        return repository.findAll();
    }
}
