package com.foody.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

//    @ManyToMany(mappedBy = "roles")
//    private List<User> users;

    public Role(){}
    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
