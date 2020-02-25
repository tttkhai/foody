package com.foody.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<Role> roles;


    public User(int id, String username, String password, String firstName, String lastName, String email, String address, String phoneNumber,  List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
    }
}
