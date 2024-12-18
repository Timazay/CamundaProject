package com.example.camundaproject.repository;

import com.example.camundaproject.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {
    Child findChildByUsername(String username);
}
