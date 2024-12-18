package com.example.camundaproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;

    @OneToMany(mappedBy = "child", fetch = FetchType.EAGER)
    private List<Task> tasks;

    public void add(Task task){
        tasks.add(task);
    }

}
