package com.example.camundaproject.repository;

import com.example.camundaproject.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long> {
    Parent findByUsername(String username);
}
