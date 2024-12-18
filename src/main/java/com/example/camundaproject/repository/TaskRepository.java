package com.example.camundaproject.repository;

import com.example.camundaproject.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findTaskByTitle(String title);

}
