package com.example.camundaproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String uniqueName;
    @OneToMany(mappedBy = "family")
    private List<Child> children;

    @OneToMany(mappedBy = "family")
    private List<Parent> parents;

    public void addChild(Child child) {
        if (child != null)
            children.add(child);
    }

    public void addChild(Parent parent) {
        if (parent != null)
            parents.add(parent);
    }
}
