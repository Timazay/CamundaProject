package com.example.camundaproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private boolean isComplete;
    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;
}
