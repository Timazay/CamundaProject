package com.example.camundaproject.service;

import com.example.camundaproject.entity.Parent;

public interface ParentServiceInterface {
    Parent parentFindByUsername(String username);
    Parent create(Parent parent);
    void update(Parent parent);
}
