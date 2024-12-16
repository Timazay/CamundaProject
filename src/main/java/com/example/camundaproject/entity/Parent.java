package com.example.camundaproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;
}
