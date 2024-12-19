package com.example.camundaproject.service;

import com.example.camundaproject.entity.Child;
import com.example.camundaproject.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildService {
    @Autowired
    private ChildRepository childRepository;

    public Child findByUsername(String username){
        return childRepository.findChildByUsername(username);
    }

    public void save(Child child){
        childRepository.save(child);
    }
}
