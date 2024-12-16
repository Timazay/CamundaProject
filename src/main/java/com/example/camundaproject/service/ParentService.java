package com.example.camundaproject.service;

import com.example.camundaproject.entity.Parent;
import com.example.camundaproject.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentService implements ParentServiceInterface {
    @Autowired
    private ParentRepository repository;

    @Override
    public Parent parentFindByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Parent create(Parent parent) {
        return repository.save(parent);
    }

    @Override
    public void update(Parent parent) {
        repository.save(parent);
    }
}
